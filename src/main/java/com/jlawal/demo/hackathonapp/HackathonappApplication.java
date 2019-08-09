package com.jlawal.demo.hackathonapp;

import com.jlawal.demo.hackathonapp.model.Product;
import com.jlawal.demo.hackathonapp.model.Supplier;
import com.jlawal.demo.hackathonapp.serviceimplementation.ConcreteProductService;
import com.jlawal.demo.hackathonapp.serviceimplementation.ConcreteSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class HackathonappApplication implements CommandLineRunner {
    @Autowired
    ConcreteProductService concreteProductService;
    @Autowired
    ConcreteSupplierService concreteSupplierService;

    public static void main(String[] args) {
        SpringApplication.run(HackathonappApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        Inserts the default records into the database if they dont exist

        if (!concreteProductService.hasDefaultRecords() || !concreteSupplierService.hasDefaultRecords()) {
            Product product1 = new Product(1000L, "Iphone", 2000.0, 20, LocalDate.of(2019, 2, 20));
            Product product2 = new Product(1001L, "Gionee", 3000.0, 40, LocalDate.of(2017, 4, 20));
//
            Supplier supplier1 = new Supplier(10000L, "John Lawal", "(641) 251-4566");
            Supplier supplier2 = new Supplier(10001L, "Mac Jon", "(641) 241-4566");
//
//
//
////
           product1.setSupplier(supplier1);
           product2.setSupplier(supplier2);

//
            supplier1.addProduct(product1);
            supplier2.addProduct(product2);
//
//
//
            concreteSupplierService.createSupplier(supplier1);
            concreteSupplierService.createSupplier(supplier2);

        }

    }

}
