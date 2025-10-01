package com.challenge.meli.adapter.persistence;

import com.challenge.meli.domain.exception.ProductNotFoundException;
import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.port.out.ProductRetrievalPort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * [ADAPTER OUT] - Persistence Adapter (JSON File).
 * Implements the Secondary Port (ProductRetrievalPort).
 * This component is responsible for knowing how to read the JSON file.
 */
@Component
public class JsonProductPersistence implements ProductRetrievalPort {

    private List<Product> products;
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Initialization: Loads the products data from the classpath's 'products.json' file.
     */
    @PostConstruct
    public void init() {
        try {
            ClassPathResource resource = new ClassPathResource("products.json");
            try (InputStream inputStream = resource.getInputStream()) {
                // Use the domain model for deserialization
                products = objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});
                System.out.println("✅ Successfully loaded " + products.size() + " products from products.json (Persistence Adapter).");
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            System.err.println("❌ ERROR: Could not load products.json file. API will not function.");
            products = List.of(); 
        }
    }

    /**
     * Implements the contract to find a product by ID.
     */
    @Override
    public Product findById(Long id) throws ProductNotFoundException {
        Optional<Product> foundProduct = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return foundProduct.orElseThrow(() -> new ProductNotFoundException(id));
    }
    
    /**
     * Implements the contract to find all products.
     */
    @Override
    public List<Product> findAll() {
        return products;
    }
}