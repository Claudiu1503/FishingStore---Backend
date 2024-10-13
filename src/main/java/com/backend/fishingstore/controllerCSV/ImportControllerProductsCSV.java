package com.backend.fishingstore.controllerCSV;

import com.backend.fishingstore.serviceCSV.ProductServiceCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportControllerProductsCSV {

    @Autowired
    private ProductServiceCSV productServiceCSV;

    @GetMapping("/import-products")
    public String importProducts() {
        productServiceCSV.importProductsFromCSV();
        return "Products imported successfully!";
    }
}
