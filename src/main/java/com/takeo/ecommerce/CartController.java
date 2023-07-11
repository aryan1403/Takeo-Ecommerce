package com.takeo.ecommerce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    private List<CartItem> cartItems = new ArrayList<>();

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAllAttributes(cartItems);
        return "cart";
    }

    @PostMapping("/add")
    public void addItemToCart(@RequestBody CartItem item) {
        cartItems.add(item);
    }

    @PutMapping("/update/{productId}")
    public void updateItemQuantity(@PathVariable String productId, @RequestParam int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(quantity);
                break;
            }
        }
    }

    @DeleteMapping("/remove/{productId}")
    public void removeItemFromCart(@PathVariable String productId) {
        cartItems.removeIf(item -> item.getProductId().equals(productId));
    }

    @GetMapping("/items")
    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
