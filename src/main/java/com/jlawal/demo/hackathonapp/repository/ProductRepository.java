package com.jlawal.demo.hackathonapp.repository;

import com.jlawal.demo.hackathonapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT max(productNumber) FROM Product")
    public Long getLastCreatedProductNumber();
}
