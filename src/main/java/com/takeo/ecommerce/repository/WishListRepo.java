package com.takeo.ecommerce.repository;

import com.takeo.ecommerce.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WishListRepo extends JpaRepository<WishList,Integer> {
    @Query(value = "SELECT product_id FROM WishList w WHERE w.created_by = :userId", nativeQuery = true)
    List<Long> findProductIdsByUser(@Param("userId") Integer userId);
    WishList findByProduct_Id(Long productId);

}
