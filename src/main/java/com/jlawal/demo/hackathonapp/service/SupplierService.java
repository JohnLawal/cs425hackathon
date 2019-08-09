package com.jlawal.demo.hackathonapp.service;

import com.jlawal.demo.hackathonapp.model.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> getAllSuppliers();

    Page<Supplier> getAllSuppliersPaged(int page);

    void createSupplier(Supplier supplier);

    boolean hasDefaultRecords();

    void saveSupplier(Supplier supplier);

    Optional<Supplier> getSupplierById(Long supplierId);

    Optional<Supplier> getSupplierBySupplierNumber(Long supplierNumber);

    Long getNextAvailableSupplierNumber();
}
