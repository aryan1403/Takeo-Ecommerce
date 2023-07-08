package com.takeo.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.takeo.ecommerce.Entity.Customer;
import com.takeo.ecommerce.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {

        Customer cus = customerRepository.save(customer);

        if (cus != null)
            return cus;
        else
            return null;
    }

    @Override
    public Customer findCustomerByEmail(String email) {

        return customerRepository.findCustomerByEmail(email);

    }

    @Override
    public List<Customer> getCustomer() {

        return customerRepository.findAll();

    }

    @Override
    public Optional<Customer> getCustomerById(String id) {

        Optional<Customer> customer = customerRepository.findById(id);

        if (customer != null)
            return customer;
        else
            return null;
    }

}
