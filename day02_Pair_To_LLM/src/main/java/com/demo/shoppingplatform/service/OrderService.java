package com.demo.shoppingplatform.service;

import com.demo.shoppingplatform.exception.InsufficientStockException;
import com.demo.shoppingplatform.exception.PriceChangedException;
import com.demo.shoppingplatform.exception.ProductNotFoundException;
import com.demo.shoppingplatform.exception.UnpaidOrderException;
import com.demo.shoppingplatform.model.Order;
import com.demo.shoppingplatform.model.Product;
import com.demo.shoppingplatform.repository.OrderRepository;
import com.demo.shoppingplatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  public boolean hasUnpaidOrders(Long customerId) {
    return orderRepository.existsByCustomerIdAndStatus(customerId, "UNPAID");
  }

  public Order createOrder(OrderRequest orderRequest) {
    Order order = new Order();
    order.setCustomerId(orderRequest.getCustomerId());
    order.setItems(orderRequest.getItems());
    order.setStatus("CREATED");
    order.setTotalAmount(calculateTotalPrice(orderRequest));
    return orderRepository.save(order);
  }

  private double calculateTotalPrice(OrderRequest orderRequest) {
    double totalPrice = 0.0;
    for (OrderItem item : orderRequest.getItems()) {
      Product product = productRepository.findById(item.getProductId())
          .orElseThrow(() -> new ProductNotFoundException("Product not found"));
      totalPrice += product.getPrice() * item.getQuantity();
    }
    return totalPrice;
  }

  public Order processOrderRequest(OrderRequest orderRequest) {
    if (hasUnpaidOrders(orderRequest.getCustomerId())) {
      throw new UnpaidOrderException("You have unpaid orders. Please complete them before creating a new order.");
    }

    for (OrderItem item : orderRequest.getItems()) {
      Product product = productRepository.findById(item.getProductId())
          .orElseThrow(() -> new ProductNotFoundException("Product not found"));
      if (product.getStock() < item.getQuantity()) {
        throw new InsufficientStockException("Insufficient stock for product: " + product.getName());
      }

      if (product.getPrice() != item.getPrice()) {
        throw new PriceChangedException("Price has changed for product: " + product.getName() + ". Please confirm the new price.");
      }
    }

    return createOrder(orderRequest);
  }
}