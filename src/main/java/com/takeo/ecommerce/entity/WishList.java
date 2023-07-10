package com.takeo.ecommerce.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
 @AllArgsConstructor
@NoArgsConstructor
@Table(name="WISHLIST")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    @ManyToOne
    //@JoinColumn(name = "created_by", nullable = false)
    @JoinColumn(name = "created_by")
    private Users createdBy;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")//,nullable=false, updatable=false)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


}
