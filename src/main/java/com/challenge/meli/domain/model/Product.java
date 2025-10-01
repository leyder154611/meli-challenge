package com.challenge.meli.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * [DOMAIN MODEL] - Core Data Structure.
 * Represents the complete product details in the Mercado Libre inspired API.
 * Uses Lombok annotations to automatically generate boilerplate code (getters, setters, constructors).
 */
@Data // Generates Getters, Setters, toString, equals, and hashCode
@NoArgsConstructor // Generates the no-args constructor required by Jackson (mandatory for JSON deserialization)
public class Product {
    private Long id;
    private String title;
    private String currency;
    private String condition;
    private Integer stockQuantity;
    private String description;
    private List<String> imageUrls;

    // Nested Objects
    private PriceInfo priceDetails;
    private SellerInfo sellerInfo;
    private InstallmentInfo installments;
    private ShippingInfo shipping;
    private List<ProductFeature> featuresList; // Lista de Grupos de Características
    private List<Variation> variations;

    // --------------------------------------------------------------------
    // --- Nested Classes for Data Structure (Also using Lombok) ---
    // --------------------------------------------------------------------

    /** Información detallada del precio, descuentos y precio original. */
    @Data
    @NoArgsConstructor
    public static class PriceInfo {
        private Double currentPrice;
        private Double originalPrice;
        private Double discountPercentage;
    }

    /** Información del vendedor (nombre, rating, volumen de ventas). */
    @Data
    @NoArgsConstructor
    public static class SellerInfo {
        private String name;
        private Double rating;
        private Integer salesVolume;
    }

    /** Detalles de las cuotas sin/con interés. */
    @Data
    @NoArgsConstructor
    public static class InstallmentInfo {
        private Integer count;
        private Double amount;
        private Double totalInterest; // 0.0 for interest-free installments
    }

    /** Detalles del envío (tiempo de entrega, si es gratis, si acepta devoluciones). */
    @Data
    @NoArgsConstructor
    public static class ShippingInfo {
        private String deliveryTime;
        private Boolean freeShipping;
        private Boolean returnsAccepted;
    }

    /**
     * [NUEVA ESTRUCTURA] Representa un grupo de características (ej. "Características Principales").
     * Contiene una lista de FeatureDetail.
     */
    @Data
    @NoArgsConstructor
    public static class ProductFeature {
        private String groupName; // E.g., "Características generales"
        private List<FeatureDetail> features; // Lista de detalles dentro del grupo
    }

    /**
     * [NUEVA ESTRUCTURA] Representa una característica individual dentro de un grupo.
     * Es el par clave-valor.
     */
    @Data
    @NoArgsConstructor
    public static class FeatureDetail {
        private String featureType; // E.g., "Fabricante"
        private String detail; // E.g., "Microsoft"
    }

    /** Variaciones del producto (ej. Color, Talla) con su respectivo ajuste de precio. */
    @Data
    @NoArgsConstructor
    public static class Variation {
        private String name; // E.g., "Color"
        private String value; // E.g., "Negro"
        private Double priceAdjustment; // E.g., 50000.00
        private String variationImageUrl;
    }
}
