package com.example.shopping.controller;

import com.example.shopping.entity.Product;
import com.example.shopping.service.ProductMaintenanceService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductMaintenanceService productMaintenanceService; // サービスクラスのインジェクションはコンストラクタが一般的

    ProductController(ProductMaintenanceService productMaintenanceService) {
        this.productMaintenanceService = productMaintenanceService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return this.productMaintenanceService.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product getProductDetail(@PathVariable String productId) {
        return this.productMaintenanceService.findById(productId);
    }
}
