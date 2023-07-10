package com.takeo.ecommerce.service;

import com.takeo.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order update(Order order);
    void deleteOrderById(long orderId);
    List<Order>getAllUserOrder(Integer user_id);
    Order getOrderByTrackingNumber(String trNumber);
    Order findOrderById(long orderId);
    Order save(Order order);

}
