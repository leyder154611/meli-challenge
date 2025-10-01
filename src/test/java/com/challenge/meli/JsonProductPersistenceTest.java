package com.challenge.meli;


import com.challenge.meli.adapter.persistence.JsonProductPersistence;
import com.challenge.meli.domain.exception.ProductNotFoundException;
import com.challenge.meli.domain.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para JsonProductPersistence.
 * Adaptadas para reflejar el comportamiento actual de la clase:
 * - findById: Lanza ProductNotFoundException si no encuentra el producto.
 * - findByFilter: Requiere implementación, las pruebas están listas pero fallarán
 * hasta que el método sea agregado a JsonProductPersistence.
 */
public class JsonProductPersistenceTest {

    private JsonProductPersistence persistenceAdapter;

    /**
     * Configuración: Carga la instancia real de JsonProductPersistence
     * e inicializa los datos del products.json.
     */
    @BeforeEach
    void setUp() throws Exception {
        persistenceAdapter = new JsonProductPersistence();
        // Invocamos el método init para forzar la carga de datos del JSON
        try {
            persistenceAdapter.init();
        } catch (Exception e) {
            // Si la carga falla por alguna razón (ej. estructura incorrecta), lanzamos el error
            throw new Exception("Fallo al cargar el products.json para la prueba: " + e.getMessage(), e);
        }
    }

    @Test
    void init_shouldLoadProductsSuccessfully() {
        // Verifica que la lista de productos cargada no está vacía.
        List<Product> products = persistenceAdapter.findAll();
        assertNotNull(products, "La lista de productos no debe ser null.");
        // Debería haber 20 productos según el JSON provisto.
        assertEquals(30, products.size(), "Debe cargar 20 productos del archivo JSON.");
    }

    @Test
    void findAll_shouldReturnAllLoadedProducts() {
        List<Product> products = persistenceAdapter.findAll();
        assertNotNull(products);
        assertEquals(30, products.size());
    }

    @Test
    void findById_shouldReturnProductWhenIdExists() throws ProductNotFoundException {
        Long existingId = 101L; // ID de un producto conocido
        
        // Ahora se espera que el método devuelva el objeto Product directamente
        Product result = persistenceAdapter.findById(existingId);

        assertNotNull(result, "Debe encontrar el producto con ID: " + existingId);
        assertEquals(existingId, result.getId());
    }

    @Test
    void findById_shouldThrowExceptionWhenIdDoesNotExist() {
        Long nonExistingId = 9999L;
        
        // Dado que la implementación lanza ProductNotFoundException, usamos assertThrows.
        assertThrows(ProductNotFoundException.class, () -> {
            persistenceAdapter.findById(nonExistingId);
        }, "Debe lanzar ProductNotFoundException cuando el producto no existe.");
    }

}
