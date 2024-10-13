package com.backend.fishingstore.controller;

import com.backend.fishingstore.model.Product;
import com.backend.fishingstore.model.User;
import com.backend.fishingstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list-all")
    public List<Product> listAllProducts() {
        return productService.getAllProducts();
    }
}
