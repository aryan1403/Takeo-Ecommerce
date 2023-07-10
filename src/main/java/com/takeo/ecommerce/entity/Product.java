package com.takeo.ecommerce.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private int sku;
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
    private String active;
    private String image;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WishList> wishlistProducts = new ArrayList<>();
   /* public void removeCategory(Category category){
        this.category.remove(category);
        category.getProducts().remove(category);
    }

    public void addCategory(Category category){
        this.category.add(category);
        category.getProducts().add(this);
    }*/

}