package com.takeo.ecommerce.service.impl;


import com.takeo.ecommerce.entity.Order;
import com.takeo.ecommerce.repository.OrderRepository;
import com.takeo.ecommerce.repository.PaymentRepository;
import com.takeo.ecommerce.service.OrderService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Order> getAll() {
        List<Order>orderList=orderRepository.findAll();
        return orderList;
    }

    @Override
    public Order update(@NotNull Order order) {
        Optional<Order>optionalOrder=orderRepository.findById(order.getId());
        Order order1=optionalOrder.get();
        if(order1!=null)
            order1=orderRepository.save(order1);
        return order1;
    }

    @Override
    public void deleteOrderById(long orderId) {

         orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getAllUserOrder(Integer user_id) {
        List<Order>userOrderList=orderRepository.findByUser_uid(user_id);

       return userOrderList;

    }

    @Override
    public Order getOrderByTrackingNumber(String trNumber) {

        Order order=orderRepository.findByOrderTackingNumber(trNumber);
        return order;
    }

    @Override
    public Order findOrderById(long orderId) {
        Optional<Order>order=orderRepository.findById(orderId);
        return order.get();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


}