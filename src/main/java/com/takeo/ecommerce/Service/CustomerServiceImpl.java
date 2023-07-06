package com.takeo.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.ecommerce.Entity.Customer;
import com.takeo.ecommerce.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(Customer customer) {

        Customer cus = customerRepository.save(customer);

        String msg = null;
        if (cus!= null)
            msg = "Registered successfully.";
        else
            msg = "Unable to register.";
        return msg;
    }

}
