package com.demo.shoppingplatform.controller;

import com.demo.shoppingplatform.model.Product;
import com.demo.shoppingplatform.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

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
}
