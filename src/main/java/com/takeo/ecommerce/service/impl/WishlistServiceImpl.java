package com.takeo.ecommerce.service.impl;


import com.takeo.ecommerce.entity.Users;
import com.takeo.ecommerce.entity.WishList;
import com.takeo.ecommerce.repository.ProductRepository;
import com.takeo.ecommerce.repository.UserRepo;
import com.takeo.ecommerce.repository.WishListRepo;
import com.takeo.ecommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WishlistServiceImpl implements WishListService {
    @Autowired
    private UserRepo uRepo;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WishListRepo wishListRepo;
    @Override
    public List<WishList> findAllWishList() {
        return null;
    }

    @Override
    public List<Long>findProductIdsByUser(Integer userId) {
        List<Long> productIds=wishListRepo.findProductIdsByUser(userId);

        return productIds;
    }

    @Override
    public List<Integer> findWishListByUser(Integer userId) {
        return null;
    }

    @Override
    public WishList createWishList(WishList wishList) {

        return wishListRepo.save(wishList);


    }

    @Override
    public WishList findWishListById(Integer WishListID) {
        return null;
    }

    @Override
    public void updateWishList(WishList wishList) {

    }

    @Override
    public void deleteWishList(Integer wishlistID) {

        wishListRepo.deleteById(wishlistID);

    }
    @Override
    public WishList findByProduct(long id) {
        return null;
    }
    public void deleteProductFromWishlist(Long productId) {
        WishList wishList = wishListRepo.findByProduct_Id(productId);
        if (wishList != null) {
            wishListRepo.delete(wishList);


}}}
