package com.takeo.ecommerce.repository;


import com.takeo.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser_uid(int uid);


    Order findByOrderTackingNumber(String OrderTackingNumber);
}
