package com.takeo.ecommerce.controller;


import com.takeo.ecommerce.dto.OrderRequest;
import com.takeo.ecommerce.dto.OrderResponse;
import com.takeo.ecommerce.entity.Order;
import com.takeo.ecommerce.entity.Payment;
import com.takeo.ecommerce.exception.PaymentException;
import com.takeo.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.UUID;

@Controller
public class OrderController {
  @Autowired
    private OrderService orderService;


    @PostMapping("/place-order")
    public OrderResponse placeOrder(@ModelAttribute("orderRequest") OrderRequest orderRequest, Model model) {

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
      model.addAttribute("res",orderResponse);
      return orderResponse;



    }
}
