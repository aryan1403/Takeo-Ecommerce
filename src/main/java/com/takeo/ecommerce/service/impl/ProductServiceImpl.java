package com.takeo.ecommerce.service.impl;
import com.takeo.ecommerce.entity.Product;
import com.takeo.ecommerce.repository.ProductRepository;
import com.takeo.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired

    private ProductRepository productRepository;

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProductsSQL(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return product;
    }

    public void createProducts(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        productRepository.deleteById(product.getId());
    }
}
