package com.takeo.ecommerce.dto;

import com.takeo.ecommerce.entity.Order;
import com.takeo.ecommerce.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;
}
