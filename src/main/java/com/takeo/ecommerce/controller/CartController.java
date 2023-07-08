package com.takeo.ecommerce.controller;

import com.takeo.ecommerce.entity.Cart;
import com.takeo.ecommerce.entity.Product;
import com.takeo.ecommerce.entity.Users;
import com.takeo.ecommerce.entity.WishList;
import com.takeo.ecommerce.service.impl.CartServiceImpl;
import com.takeo.ecommerce.service.impl.ProductServiceImpl;
import com.takeo.ecommerce.service.impl.UserService;
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
public class CartController {

        @Autowired
        private WishlistServiceImpl wishlistServiceimpl;
        @Autowired
        private UserService userService;
        @Autowired
        private ProductServiceImpl productService;
        @Autowired
        private CartServiceImpl cartService;
        @GetMapping("User/addCart/{productId}")
        public String addToCart(@PathVariable Long productId, @NotNull HttpSession session, Model model) {
            Users user = (Users) session.getAttribute("users");
            if (user == null) {
                // User not logged in, redirect to login page
                return "redirect:/login";
            }
            Product product =productService.findProductById(productId);
            product.getName();
            // Retrieve or create the user's wishlist
            Cart cart=new Cart();
            cart.setUserId(user);
            cart.setProduct(product);
            Cart cart1=cartService.createCart(cart);
            model.addAttribute("msg","added in wishList successfully");
            return "redirect:/UserProducts";
        }
        @GetMapping("User/CartDisplay")
        public String findAllCart(@NotNull Model model, @NotNull HttpSession session) {
            Users user = (Users) session.getAttribute("users");
            if (user == null) {
                return "redirect:/login";
            }
            int userId = user.getUid();
            List<Long> productIds =cartService.findCartIdsByUsers(userId);
            List<Product>productList=productService.getProductsByIds(productIds);
            model.addAttribute("products",productList );
            return "UserCartlist";
        }

        @GetMapping("/deletee/{id}")
        public String deleteProductFromCart(@PathVariable("id") Long idd, @NotNull Model model) {
            cartService.deleteProductFromCart(idd);
            model.addAttribute("msg","Remove successfully");
            return "redirect:/User/CartDisplay?success";
        }

    }


