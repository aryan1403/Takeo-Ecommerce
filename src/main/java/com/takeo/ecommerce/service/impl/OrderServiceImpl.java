package com.takeo.ecommerce.service.impl;


import com.takeo.ecommerce.repository.OrderRepository;
import com.takeo.ecommerce.repository.PaymentRepository;
import com.takeo.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentRepository paymentRepository;


   /* @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

 return null;
   }*/
}