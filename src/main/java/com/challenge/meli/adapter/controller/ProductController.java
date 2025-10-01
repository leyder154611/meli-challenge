/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.meli.adapter.controller;

import com.challenge.meli.domain.exception.ProductNotFoundException;
import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.port.in.ProductServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * [ADAPTER IN] - Web API Adapter (Controller).
 * Uses the Primary Port (ProductServicePort) to drive the application.
 * It is responsible for mapping HTTP requests/responses and handling exceptions.
 */
@RestController
@RequestMapping("/api/products")
@Tag(name = "Productos", description = "Operaciones relacionadas con el catálogo de productos")
public class ProductController {

    private final ProductServicePort productServicePort;

    // Dependency Injection: Injects the Primary Port implementation (ProductService)
    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }
    
    /**
     * Primary Endpoint to fetch a list of all products.Mapped to: GET /meli/api/products/
     * @return
     */
    @GetMapping
    @Operation(summary = "Obtiener listado de productos", description = "Busca y devuelve los detalles completos de todos los productos, estructura insipirada en MELI")
    public List<Product> getProductList() {
        return productServicePort.getAllProducts();
    }

    /**
     * Endpoint to fetch product details by ID.Mapped to: GET /meli/api/products/{id}
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un producto por ID", description = "Busca y devuelve los detalles completos de un producto usando su identificador único.")
    public Product getProductDetails(@PathVariable Long id) {
        // Calls the Application Service (Core)
        return productServicePort.getProductDetails(id);
    }

    /**
     * Exception Handler for the ProductNotFoundException.This decouples the core domain exception from the web framework's HTTP status.
     * @param ex
     * @return 
     */
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(ProductNotFoundException ex) {
        return ex.getMessage();
    }
}
