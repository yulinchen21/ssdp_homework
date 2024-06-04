package com.demo.shoppingplatform.service;

import com.demo.shoppingplatform.model.Product;
import com.demo.shoppingplatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getProducts(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return productRepository.findAll(pageable).getContent();
  }

  public Product getProductById(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("Product not found"));
  }
}
