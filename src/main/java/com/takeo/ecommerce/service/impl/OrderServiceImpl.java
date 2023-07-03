package com.takeo.ecommerce.service.impl;


import com.takeo.ecommerce.dto.OrderRequest;
import com.takeo.ecommerce.dto.OrderResponse;
import com.takeo.ecommerce.entity.Order;
import com.takeo.ecommerce.entity.Payment;
import com.takeo.ecommerce.exception.PaymentException;
import com.takeo.ecommerce.repository.OrderRepository;
import com.takeo.ecommerce.repository.PaymentRepository;
import com.takeo.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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