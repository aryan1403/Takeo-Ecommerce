package com.takeo.ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.takeo.ecommerce.Entity.Customer;
import com.takeo.ecommerce.Service.CustomerServiceImpl;

@Controller
public class CustomerController {

    private CustomerServiceImpl customerService;

    //add the course

    @PostMapping("/register")
    // @RequestMapping(value = "/insert", method= RequestMethod.POST)
    public String handleRegisterForm(@ModelAttribute("customer") Customer customer, Model model) {

        model.addAttribute("customer", customer);
        
        return "customerregister";
    }

}
