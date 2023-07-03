package com.takeo.ecommerce.repository;


import com.takeo.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderTackingNumber(String OrderTackingNumber);
}
