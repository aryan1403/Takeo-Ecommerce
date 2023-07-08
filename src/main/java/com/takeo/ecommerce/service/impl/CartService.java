package com.takeo.ecommerce.service.impl;

import com.takeo.ecommerce.entity.Cart;
import com.takeo.ecommerce.entity.WishList;

import java.util.List;

public interface CartService {
    List<Cart> findAllCartList();

    List<Long>findCartIdsByUsers(Integer userId);

    List<Integer> findCardListByUser(Integer userId);

    Cart createCart(Cart cart);

    Cart findCardById(Integer cartId);

    void updateCart(Cart cart);

    public void deleteCarr(Integer cardId);

    Cart findByProductId(long id);

    List<Long>findCartIdsByUser(Integer userId);

    List<Integer> findCartByUser(Integer userId);

    Cart findCartById(Integer WishListID);

    void deleteCart(Integer cartID);

    Cart findByCart(long id);
}
