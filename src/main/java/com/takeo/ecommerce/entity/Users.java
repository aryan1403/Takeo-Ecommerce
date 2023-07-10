package com.takeo.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="UID")
    private int uid;
    @Column(name="UNAME")
    private String uname;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="PHONE")
    private long phone;
    @Column(name="EMAIL")
    private String email;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="ZIP")
    private String zip;
    @Column(name="GENDER")
    private String gender;

    @Column(name="PASSWORD")
    private String password;
    @Column (name="ROLE_ID")
    private int role_id=2;
    //@ManyToMany
    //@JoinTable(name = "user_product",
           // joinColumns = @JoinColumn(name = "user_id"),
            //inverseJoinColumns = @JoinColumn(name = "product_id"))
    //private List<Product> wishlist;

}
