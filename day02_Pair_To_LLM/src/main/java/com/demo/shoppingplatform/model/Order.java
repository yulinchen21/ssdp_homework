package com.demo.shoppingplatform.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long customerId;
  private String status;
  private Double totalAmount;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderItem> items;

  // Constructors
  public Order(List<OrderItem> items) {
    this.items = items;
  }

  public Order(Long customerId, String status, Double totalAmount, List<OrderItem> items) {
    this.customerId = customerId;
    this.status = status;
    this.totalAmount = totalAmount;
    this.items = items;
  }

  public Order() {
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }


  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(final List<OrderItem> items) {
    this.items = items;
  }
}