# `prompts.md` ✨

## Prompts para la Construcción del API (Arquitectura Hexagonal) 🧑‍💻

Estos *prompts* simulan la secuencia de solicitudes necesarias para construir el API de detalle productos utilizando **Java 21**, **Spring Boot 3** y la **Arquitectura Hexagonal** (*Ports and Adapters*).

La **Arquitectura Hexagonal** aísla el **Dominio** (lógica de negocio) de la **Infraestructura** (Web, Bases de Datos).

---

### Paso a Paso - Prompts
> "Crea el código Java Spring boot para una aplicación backend que retorne conjunto de datos inspirado en Mercado Libre. La persistencia la debe hacer con un archivo JSON almacenado en el Storage de la aplicación"

```java
// Proposito: Crear las bases del proyecto y mostrando el primer acercamiento al APP recomendado por la IA
```
> "Ahora pasa los elementos a una arquitectura hexagonal, donde este distribuidos todos los modelos, controladores, servicios y persistencias a la data"

```java
Propósito: Establecer la arquitectura base del proyecto.
Resultado Clave: Creación de las carpetas domain, port, y adapter.
```
> "actualiza el modelo products y el archivo json, agrega una columna featuresList, donde el modelo debe ser el siguiente: featuresList: [ {"groupName":"Caracteristicas Principales", "features" : [ {"featureType": "Color principal", \t \t \t \t \t "detail": "Negro"}, {"featureType": "Otra caracteristicas x", "detail": "Blindado"} ]}, .... aqui el resto de grupos que puedan existir ], genera 30 productos de diferente categoria, sector, colores, para ver algo mas global y como se comporta como varios productos y varias caracteristicas dentro de cada grupo"

```java
Propósito: Definir la estructura compleja de características del producto (grupos anidados).
Resultado Clave: Refactorización de Product.java y actualización de products.json (30 registros jerárquicos).
```
