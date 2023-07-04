package com.takeo.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.takeo.ecommerce.entity.Customer;

@Controller
public class customerController {

    @PostMapping("/insert")
    // @RequestMapping(value = "/insert", method= RequestMethod.POST)
    public String handleRegisterForm(@ModelAttribute("customer") Customer customer, Model model) {

        model.addAttribute("customer", customer);
        
        return "customerregister";
    }

}
