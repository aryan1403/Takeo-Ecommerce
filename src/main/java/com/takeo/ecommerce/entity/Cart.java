package com.takeo.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @OneToOne
    //@JoinColumn(name = "created_by", nullable = false)
    @JoinColumn(name = "user_id")
    private Users userId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")//,nullable=false, updatable=false)
    private Product product;




}
