package com.demo.shoppingplatform.service;

import com.demo.shoppingplatform.model.OrderItem;
import java.util.List;

@SuppressWarnings({"PMD.DataClass"})
public class OrderRequest {
  private Long customerId;
  private List<OrderItem> items;

  public OrderRequest(Long customerId, List<OrderItem> items) {
    this.customerId = customerId;
    this.items = items;
  }

  // Getters and Setters
  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }
}