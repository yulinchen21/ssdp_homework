package com.demo.shoppingplatform.repository;

import com.demo.shoppingplatform.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findByCustomerId(Long customerId);
  boolean existsByCustomerIdAndStatus(Long customerId, String status);
}