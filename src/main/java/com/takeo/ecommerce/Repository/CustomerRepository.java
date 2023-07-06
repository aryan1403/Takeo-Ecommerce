package com.takeo.ecommerce.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.takeo.ecommerce.Entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
