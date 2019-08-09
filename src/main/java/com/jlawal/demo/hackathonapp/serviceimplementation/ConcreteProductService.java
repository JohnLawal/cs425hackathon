package com.jlawal.demo.hackathonapp.serviceimplementation;

import com.jlawal.demo.hackathonapp.model.Product;
import com.jlawal.demo.hackathonapp.repository.ProductRepository;
import com.jlawal.demo.hackathonapp.service.ProductService;
import com.jlawal.demo.hackathonapp.utility.AppValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Optional;

@Service
public class ConcreteProductService implements ProductService {
    private ProductRepository productRepository;

    public ConcreteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getAllProduct(int page) {
        return productRepository.findAll(PageRequest.of(page, AppValues.ENTRIES_PER_PAGE.iVal(), Sort.by(AppValues.PRODUCT_SORT_BY.val())));

    }
    @Override
    public boolean hasDefaultRecords() {
        return productRepository.count() > 0;
    }


    @Override
    public Product createProduct(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Long getNextAvailableProductNumber() {
        return (productRepository.getLastCreatedProductNumber() + 1);
    }
}
