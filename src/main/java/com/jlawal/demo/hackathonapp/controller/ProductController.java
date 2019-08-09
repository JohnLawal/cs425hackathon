package com.jlawal.demo.hackathonapp.controller;

import com.jlawal.demo.hackathonapp.model.Product;
import com.jlawal.demo.hackathonapp.model.Supplier;
import com.jlawal.demo.hackathonapp.serviceimplementation.ConcreteProductService;
import com.jlawal.demo.hackathonapp.serviceimplementation.ConcreteSupplierService;
import com.jlawal.demo.hackathonapp.utility.AppHelper;
import com.jlawal.demo.hackathonapp.utility.AppValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ConcreteProductService concreteProductService;

    @Autowired
    ConcreteSupplierService concreteSupplierService;

    @GetMapping(value = {"/hackathonapp/products", "/hackathonapp/products/list"})
    public ModelAndView viewProducts(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageTitle", "Existing Products");
        modelAndView.addObject("pageLinks", AppHelper.pageLinks);
        modelAndView.addObject("products", concreteProductService.getAllProduct(page));
        modelAndView.addObject("currentPageNo", page);
        modelAndView.setViewName(AppValues.VIEW_PRODUCTS_PAGE.val());
        return modelAndView;
    }

    @GetMapping(value = {"/hackathonapp/products/new"})
    public ModelAndView getNewAccountCreationPage() {
        Product product = new Product();
        product.setSupplier(new Supplier());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(getModelMap());
        modelAndView.addObject("product", product);
        modelAndView.setViewName(AppValues.NEW_PRODUCT_PAGE.val());
        return modelAndView;
    }

    @PostMapping(value = {"/hackathonapp/products/new"})
    public String createNewAccount(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            try {
                //create the product
                Long supplierNumber = product.getSupplier().getSupplierNumber();
                Supplier owningSupplier = concreteSupplierService.getSupplierBySupplierNumber(supplierNumber).get();


                product.setProductNumber(concreteProductService.getNextAvailableProductNumber());
                product.setSupplier(owningSupplier);

                owningSupplier.addProduct(product);
                concreteSupplierService.saveSupplier(owningSupplier);

                return AppValues.REDIRECT.val() + AppHelper.pageLinks.get("viewProducts");
            } catch (Exception ex) {

                model.addAttribute("creationException", "Failed! An Error Occurred While Trying To Create This Product");
                return AppValues.NEW_PRODUCT_PAGE.val();
            }
        } else {
            System.out.println(bindingResult.getAllErrors());

            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAllAttributes(getModelMap());

            return AppValues.NEW_PRODUCT_PAGE.val();
        }
    }

    private Map<String, Object> getModelMap() {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("pageTitle", "Create A New Product");
        modelMap.put("pageLinks", AppHelper.pageLinks);
        modelMap.put("suppliers", concreteSupplierService.getAllSuppliers());
        return modelMap;
    }
}
