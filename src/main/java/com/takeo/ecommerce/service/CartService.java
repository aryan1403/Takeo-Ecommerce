package com.takeo.ecommerce.service;

import com.takeo.ecommerce.entity.Cart;
import com.takeo.ecommerce.entity.WishList;

import java.util.List;

public interface CartService {
    List<Long>findCartIdsByUsers(Integer userId);

    List<Integer> findCardListByUser(Integer userId);

    Cart createCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(Integer cartID);


}
