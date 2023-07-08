package com.takeo.ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.takeo.ecommerce.Entity.Customer;
import com.takeo.ecommerce.Exception.RecordNotFoundException;
import com.takeo.ecommerce.Service.CustomerServiceImpl;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/register")
    public String showCustomerRegistrationForm(Customer customer, Model model) {

        return "customer-register";
    }

    // adding the customer

    @PostMapping("/processRegistration")
    public String processCustomerRegistration(@ModelAttribute Customer customer, Model model) {

        customerService.addCustomer(customer);

        return "success-page";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileUser(Model model, Customer customer) {

        List<Customer> customer1 = customerService.getCustomer();

        model.addAttribute("customer1", customer1);

        return "profile";
    }

    // @PostMapping(path= {"/update/{customerId}"})
	// public String update(@ModelAttribute Customer customer, @PathVariable String customerId)
	// {
		
	// 	System.out.println(customerId);
	// 	customer.setCustomerId(customerId);
    //     customerService.addCustomer(customer);

	// 	  return "edit-profile";
		
	// }

    @RequestMapping(path = "/update/{customerId}")
    public String update(Model model, @PathVariable("customerId") String _id) throws RecordNotFoundException {

        Optional<Customer> customerOptional = customerService. getCustomerById(_id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            model.addAttribute("customer", customer);
        } else {
            throw new RecordNotFoundException("Customer ID not found : " + _id);
        }

        return "edit-profile";
    }

}