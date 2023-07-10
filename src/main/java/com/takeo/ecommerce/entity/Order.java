package com.takeo.ecommerce.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SENDER_NAME")
    private String senderName;
    @Column(name = "RECEIVER_NAME")
    private String receiverName;
    @Column(name = "RECEIVER_EMAIL")
    private String receiverEmail;
    @Column(name = "RECEIVER_Address")
    private String reciverAddress;
    private String orderTackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @ManyToOne
    //@JoinColumn(name = "created_by", nullable = false)
    @JoinColumn(name = "user_id")
    private Users user;
    /*@OneToOne
    @JoinColumn(name = "product_id")
    private Product product;*/





}
