package com.jlawal.demo.hackathonapp.serviceimplementation;

import com.jlawal.demo.hackathonapp.model.Supplier;
import com.jlawal.demo.hackathonapp.repository.SupplierRepository;
import com.jlawal.demo.hackathonapp.service.SupplierService;
import com.jlawal.demo.hackathonapp.utility.AppValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcreteSupplierService implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll(Sort.by("supplierNumber"));
    }

    @Override
    public Page<Supplier> getAllSuppliersPaged(int page) {
        return supplierRepository.findAll(PageRequest.of(page, AppValues.ENTRIES_PER_PAGE.iVal(), Sort.by(AppValues.SUPPLIER_SORT_BY.val())));
    }
    @Override
    public boolean hasDefaultRecords() {
        return supplierRepository.count() > 0;
    }
    @Override
    public void createSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> getSupplierById(Long supplierId) {
        return supplierRepository.findById(supplierId);
    }

    @Override
    public Optional<Supplier> getSupplierBySupplierNumber(Long supplierNumber) {
        return supplierRepository.findSupplierBySupplierNumberEquals(supplierNumber);
    }

    @Override
    public Long getNextAvailableSupplierNumber() {
        return (supplierRepository.getLastRegisteredSupplierNumber() + 1);
    }
}
