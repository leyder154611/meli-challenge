/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.meli;

import com.challenge.meli.application.service.ProductService;
import com.challenge.meli.domain.exception.ProductNotFoundException;
import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.port.out.ProductRetrievalPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para el ProductService, enfocado en la lógica de negocio
 * y la interacción con el puerto de persistencia (ProductRetrievalPort).
 *
 * Se utiliza Mockito para simular (mockear) el comportamiento del puerto.
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    // Simula la dependencia del puerto de salida
    @Mock
    private ProductRetrievalPort productRetrievalPort;

    // Inyecta las dependencias mockeadas en el servicio a probar
    @InjectMocks
    private ProductService productService;

    // Datos de prueba
    private Product testProduct;
    private List<Product> productList;

    @BeforeEach
    void setUp() {
        // Inicialización de un producto de prueba simple usando Lombok @NoArgsConstructor y Setters (gracias a @Data)
        testProduct = new Product();
        testProduct.setId(101L);
        testProduct.setTitle("Control Elite Series 2");
        testProduct.setCurrency("ARS");

        Product anotherProduct = new Product();
        anotherProduct.setId(102L);
        anotherProduct.setTitle("Smart TV Samsung");
        anotherProduct.setCurrency("CLP");

        productList = Arrays.asList(testProduct, anotherProduct);
    }

    // --- Pruebas para getAllProducts() ---

    @Test
    void getAllProducts_shouldReturnAllProducts() {
        // Configuración del mock: cuando se llame a findAll(), retorna la lista de prueba.
        when(productRetrievalPort.findAll()).thenReturn(productList);

        // Ejecución
        List<Product> result = productService.getAllProducts();

        // Verificación
        assertNotNull(result);
        assertEquals(2, result.size());
        // Verifica que se llamó al método del puerto exactamente una vez.
        verify(productRetrievalPort, times(1)).findAll();
    }

    @Test
    void getAllProducts_shouldReturnEmptyListIfNoProductsFound() {
        // Configuración del mock: cuando se llame a findAll(), retorna una lista vacía.
        when(productRetrievalPort.findAll()).thenReturn(List.of());

        // Ejecución
        List<Product> result = productService.getAllProducts();

        // Verificación
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(productRetrievalPort, times(1)).findAll();
    }

    // --- Pruebas para getProductById() ---

    @Test
    void getProductById_shouldReturnProductWhenFound() throws ProductNotFoundException {
        Long productId = 101L;
        
        // Creamos un Optional<Product> explícito.
        Product foundOptional = testProduct;

        // Configuración del mock: cuando se llama a findById con el ID 101L, retorna el producto.
        doReturn(foundOptional).when(productRetrievalPort).findById(productId);

        // Ejecución
        Product result = productService.getProductDetails(productId);

        // Verificación
        assertNotNull(result);
        assertEquals(productId, result.getId());
        assertEquals("Control Elite Series 2", result.getTitle());
        verify(productRetrievalPort, times(1)).findById(productId);
    }
}

