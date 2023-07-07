package com.takeo.ecommerce.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    //@NotEmpty
    //@Column(nullable = false,unique = true)
    //@Size(min = 2,message = "Name should have  at least 2 Characters")
    private String name;
    //@NotEmpty
    //@Size(min = 2,message = "Description should have  at least 2 Characters")
    private String description;
    //@NotEmpty
    //@Size(min = 2,message = "Price should be Digits")
    private BigDecimal price;
    //@NotEmpty
    private boolean active;
    private String image;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @ManyToOne
    private Category category;
    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<WishList> wishList;


    /*public void removeCategory(Category category){
        this.categories.remove(category);
        category.getProducts().remove(category);
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.getProducts().add(this);
    }*/

}