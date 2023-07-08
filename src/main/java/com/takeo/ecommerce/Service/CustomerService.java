package com.takeo.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import com.takeo.ecommerce.Entity.Customer;

public interface CustomerService {
    
//resgister the customer into the database

public Customer addCustomer(Customer customer);

public Customer findCustomerByEmail (String email);

public List<Customer> getCustomer();

public Optional<Customer> getCustomerById(String id);

}
