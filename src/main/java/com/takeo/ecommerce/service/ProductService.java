package com.takeo.ecommerce.service;



import com.takeo.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
