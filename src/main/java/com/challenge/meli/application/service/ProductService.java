/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.meli.application.service;

import com.challenge.meli.domain.exception.ProductNotFoundException;
import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.port.in.ProductServicePort;
import com.challenge.meli.domain.port.out.ProductRetrievalPort;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * [APPLICATION SERVICE] - Implements the Primary Port (ProductServicePort).
 * Contains the orchestration of domain logic and uses the Secondary Port (ProductRetrievalPort).
 * This layer is independent of Spring MVC or persistence technology.
 */
@Service
public class ProductService implements ProductServicePort {

    private final ProductRetrievalPort productRetrievalPort;

    // Dependency Injection: Injects the Secondary Port implementation (which will be the JsonAdapter)
    public ProductService(ProductRetrievalPort productRetrievalPort) {
        this.productRetrievalPort = productRetrievalPort;
    }
    
    /**
     * Retrieves a list of all products.
     */
    @Override
    public List<Product> getAllProducts() {
        return productRetrievalPort.findAll();
    }

    /**
     * Business logic to retrieve the product details.
     */
    @Override
    public Product getProductDetails(Long id) throws ProductNotFoundException {
        // Here, we could add business rules (e.g., logging, permissions check)
        // before calling the retrieval port.
        
        return productRetrievalPort.findById(id);
    }
}
