package com.takeo.ecommerce;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface cartRepository extends MongoRepository <CartItem, Integer >{
    
    
}
