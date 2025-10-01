/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.meli.domain.exception;

/**
 *
 * @author lmendieta
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Could not find product with ID: " + id);
    }
}