package com.takeo.ecommerce.repository;

import com.takeo.ecommerce.entity.Cart;
import com.takeo.ecommerce.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
        //find list of ids from cart by user_id
        @Query(value = "SELECT product_id FROM Cart w WHERE w.user_id = :userId", nativeQuery = true)
        List<Long> findProductIdsByUsers(@Param("userId") Integer userId);

        //Cart product find by product_id
         Cart findByProduct_Id(Long productId);

    }

