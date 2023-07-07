package com.takeo.ecommerce.service;



import com.takeo.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);

    List<Product> findAllProducts();
    Product findProductById(Long id);
     void createProducts(Product product);



    Product updateProduct(Product product);


    public void deleteProduct(Long id);

}
