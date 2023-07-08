package com.takeo.ecommerce.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CUSTOMERS")
public class Customer {

    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String sex;
    private String email;
    private String password;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;
 
}