package com.takeo.ecommerce.controller;

import com.takeo.ecommerce.entity.Product;
import com.takeo.ecommerce.entity.Users;


import com.takeo.ecommerce.entity.WishList;
import com.takeo.ecommerce.service.impl.UserService;
import com.takeo.ecommerce.service.impl.ProductServiceImpl;
import com.takeo.ecommerce.service.impl.WishlistServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WishListController {
    @Autowired
    private WishlistServiceImpl wishlistServiceimpl;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("User/WishListsDisplay")
    public String findAllWishLists(@NotNull Model model, @NotNull HttpSession session) {
        Users user = (Users) session.getAttribute("users");
        if (user == null) {
            return "redirect:/login";
        }
        int userId = user.getUid();
        List<Long> productIds = wishlistServiceimpl.findProductIdsByUser(userId);
        List<Product>productList=productService.getProductsByIds(productIds);
        model.addAttribute("products",productList );
        return "UserWishList";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductFromWishlist(@PathVariable Long id, @NotNull Model model) {
            wishlistServiceimpl.deleteProductFromWishlist(id);
        return "redirect:/User/WishListsDisplay?success";
    }
    @GetMapping("User/addWishList/{productId}")
    public String addToWishlist(@PathVariable Long productId, @NotNull HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("users");
        if (user == null) {
            // User not logged in, redirect to login page
            return "redirect:/login";
        }

        Product product = productService.findProductById(productId);
        Long productID = product.getId();
        List<Long> wishlist_productID = wishlistServiceimpl.findProductIdsByUser(user.getUid());

        // Check if the product is already in the wishlist
        boolean isProductInWishlist = wishlist_productID.contains(productID);

        if (isProductInWishlist){
            return "redirect:/User/WishListsDisplay?fail";}

            WishList wishList = new WishList();
            wishList.setCreatedBy(user);
            wishList.setProduct(product);
            wishList.setCategory(product.getCategory());
            WishList wishList1 = wishlistServiceimpl.createWishList(wishList);
        return "redirect:/User/WishListsDisplay?added";}
    }



