package com.backend.fishingstore.serviceCSV;

import com.backend.fishingstore.model.Category;
import com.backend.fishingstore.model.Product;
import com.backend.fishingstore.repository.CategoryRepository;
import com.backend.fishingstore.repository.ProductRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ProductServiceCSV {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void importProductsFromCSV() {
        String filePath = "src/main/resources/csv/products_fishing_store.csv";

        // Formatter pentru data și ora în formatul "yyyy-MM-dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Sari peste header

            while ((line = reader.readNext()) != null) {
                String categoryName = line[0];
                String productName = line[1];
                String description = line[2];
                BigDecimal price = new BigDecimal(line[3]);
                String imageUrl = line[4];

                // Parsarea corectă a datelor folosind formatter-ul specificat
                LocalDateTime createdAt = LocalDateTime.parse(line[5], formatter);
                LocalDateTime updatedAt = LocalDateTime.parse(line[6], formatter);

                // Găsirea sau crearea categoriei
                Optional<Category> optionalCategory = categoryRepository.findByName(categoryName);
                Category category;
                if (optionalCategory.isPresent()) {
                    category = optionalCategory.get();
                } else {
                    category = Category.builder()
                            .name(categoryName)
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();
                    categoryRepository.save(category);
                }

                // Creează produsul și salvează-l în baza de date
                Product product = Product.builder()
                        .name(productName)
                        .description(description)
                        .price(price)
                        .category(category)
                        .imageUrl(imageUrl)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .build();

                productRepository.save(product);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
