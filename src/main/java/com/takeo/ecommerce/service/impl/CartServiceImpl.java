package com.takeo.ecommerce.service.impl;

import com.takeo.ecommerce.entity.Cart;

import com.takeo.ecommerce.repository.CartRepository;
import com.takeo.ecommerce.repository.ProductRepository;
import com.takeo.ecommerce.repository.UserRepo;

import com.takeo.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {


    @Autowired
    private UserRepo uRepo;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;


    @Override
    public List<Long> findCartIdsByUsers(Integer userId) {
        List<Long>productId=cartRepository.findProductIdsByUsers(userId);
        return productId;
    }

    @Override
    public List<Integer> findCardListByUser(Integer userId) {
        return null;
    }

    @Override
    public Cart createCart(Cart cart) {

        return cartRepository.save(cart);
    }


    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public void deleteCart(Integer cartID) {
        cartRepository.deleteById(cartID);

    }

    public void deleteProductFromCart(Long productId) {
        Cart cart = cartRepository.findByProduct_Id(productId);
        if (cart != null) {
            cartRepository.delete(cart);

        }}
        }

