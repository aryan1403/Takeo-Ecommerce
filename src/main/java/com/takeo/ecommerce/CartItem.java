package com.takeo.ecommerce;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document



public class CartItem {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    
   
    
    
}
