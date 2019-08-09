package com.jlawal.demo.hackathonapp.service;

import com.jlawal.demo.hackathonapp.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {

    Page<Product> getAllProduct(int page);

    Product createProduct(Product product);

    boolean hasDefaultRecords();

    Optional<Product> getProductById(Long productId);

    Long getNextAvailableProductNumber();

}
