package com.jlawal.demo.hackathonapp.repository;

import com.jlawal.demo.hackathonapp.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT max(supplierNumber) FROM Supplier")
    public Long getLastRegisteredSupplierNumber();

    public Optional<Supplier> findSupplierBySupplierNumberEquals(Long supplierNumber);
}
