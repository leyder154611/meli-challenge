package com.challenge.meli.domain.port.out;

import com.challenge.meli.domain.exception.ProductNotFoundException;
import com.challenge.meli.domain.model.Product;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lmendieta
 */
public interface ProductRetrievalPort {
    
    /**
     * Fetches all available Products from the data source.
     * @return A list of all Products.
     */
    List<Product> findAll();

    /**
     * Fetches a Product by its ID from the data source.
     * @param id The product ID.
     * @return The found Product.
     * @throws ProductNotFoundException if the product is not found.
     */
    Product findById(Long id) throws ProductNotFoundException;
}