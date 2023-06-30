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

    /*public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }*/

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
