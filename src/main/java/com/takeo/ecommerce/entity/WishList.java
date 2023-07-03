package com.takeo.ecommerce.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(targetEntity = Users.class,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Users user;
    //@OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    //@JoinColumn(name="user_id")
    //private User user;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
