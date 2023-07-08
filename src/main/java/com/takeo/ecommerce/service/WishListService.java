package com.takeo.ecommerce.service;

import com.takeo.ecommerce.entity.Users;
import com.takeo.ecommerce.entity.WishList;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishListService {
    List<WishList> findAllWishList();

    List<Long>findProductIdsByUser(Integer userId);

    List<Integer> findWishListByUser(Integer userId);

    WishList createWishList(WishList wishList);

    WishList findWishListById(Integer WishListID);

    void updateWishList(WishList wishList);

    public void deleteWishList(Integer wishlistID);

    WishList findByProduct(long id);
}
