package com.backend.fishingstore.service;

import com.backend.fishingstore.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

}
