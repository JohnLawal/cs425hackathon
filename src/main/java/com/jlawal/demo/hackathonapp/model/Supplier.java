package com.jlawal.demo.hackathonapp.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @Column
    private Long supplierNumber;

    @NotBlank(message = "Please enter the supplier's name")
    @Column(nullable = false)
    private String supplierName;

    @NotBlank(message = "Please enter the supplier's phone number")
    @Column(nullable = false)
    private String contactPhoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="join_sup_prod")
    private List<Product> productList = new ArrayList<>();


    public Supplier() {
    }

    public Supplier(Long supplierNumber, String supplierName,  String contactPhoneNumber, List<Product> productList) {
        this.supplierNumber = supplierNumber;
        this.supplierName = supplierName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.productList = productList;
    }
    public Supplier(Long supplierNumber, String supplierName,  String contactPhoneNumber) {
        this.supplierNumber = supplierNumber;
        this.supplierName = supplierName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Long supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierNumber=" + supplierNumber +
                ", supplierName='" + supplierName + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", productList=" + productList +
                '}';
    }
}
