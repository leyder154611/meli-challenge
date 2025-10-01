# `prompts.md` ✨

## Prompts para la Construcción del API (Arquitectura Hexagonal) 🧑‍💻

Estos *prompts* simulan la secuencia de solicitudes necesarias para construir el API de productos utilizando **Java 21**, **Spring Boot 3** y la **Arquitectura Hexagonal** (*Ports and Adapters*).

La **Arquitectura Hexagonal** aísla el **Dominio** (lógica de negocio) de la **Infraestructura** (Web, Bases de Datos).

---

### 1. Dominio y Puertos (El Núcleo) 🧱

Definición de las estructuras de datos esenciales y los contratos (**interfaces**) de la aplicación.

#### Prompt 1.1: Entidad de Dominio y DTO
> "Crea el código Java para la **entidad de dominio Producto** con atributos `id` (Long), `nombre` (String), y `precio` (Double). Genera también el **DTO `ProductoDTO`** para las operaciones de E/S. Usa las anotaciones de **Lombok** (`@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`)."

```java
// Entidad de Dominio: com.api.domain.model.Producto.java
// DTO: com.api.application.dto.ProductoDTO.java
