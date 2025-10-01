/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.meli.domain.port.in;

import com.challenge.meli.domain.exception.ProductNotFoundException;
import com.challenge.meli.domain.model.Product;
import java.util.List;

/**
 *
 * @author lmendieta
 */
public interface ProductServicePort {
    
    /**
     * Retrieves a list of all products.
     * @return List of all Product objects.
     */
    List<Product> getAllProducts();

    /**
     * Retrieves the complete product details.
     * @param id The product ID.
     * @return The complete Product object.
     * @throws ProductNotFoundException if the product is not found.
     */
    Product getProductDetails(Long id) throws ProductNotFoundException;
}