package com.demo.shoppingplatform.controller;

import com.demo.shoppingplatform.exception.InsufficientStockException;
import com.demo.shoppingplatform.exception.PriceChangedException;
import com.demo.shoppingplatform.exception.ProductNotFoundException;
import com.demo.shoppingplatform.exception.UnpaidOrderException;
import com.demo.shoppingplatform.model.Order;
import com.demo.shoppingplatform.model.Product;
import com.demo.shoppingplatform.service.OrderRequest;
import com.demo.shoppingplatform.service.OrderService;
import com.demo.shoppingplatform.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private OrderService orderService;

  @GetMapping("/products")
  public List<Product> getProducts(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "15") int size) {

    if (size > 30) {
      size = 30;
    }

    // Page numbers in Spring Data JPA start from 0
    return productService.getProducts(page - 1, size);
  }

  @PostMapping("/orders")

  public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
    try {
      Order order = orderService.processOrderRequest(orderRequest);
      return ResponseEntity.status(HttpStatus.CREATED)
          .body("Order created successfully. Order ID: " + order.getId() + ". Please proceed to payment.");
    } catch (UnpaidOrderException | ProductNotFoundException | InsufficientStockException |
             PriceChangedException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
