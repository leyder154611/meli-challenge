# Ejecución del Proyecto Spring Boot (Java 21)

Este archivo explica los pasos necesarios para compilar y ejecutar la aplicación Spring Boot, que incluye la documentación interactiva de la API a través de Swagger UI.

## 1. Requisitos Previos

Asegúrese de tener instaladas las siguientes herramientas:

* **Java Development Kit (JDK):** Versión **21** o superior.
* **Apache Maven:** Versión 3.6+ (si usa Maven).
* **Git:** Para clonar el repositorio.
* https://github.com/leyder154611/meli-challenge

---

## 2. Compilación del Proyecto

Utilice su herramienta de construcción preferida (**Maven**) para compilar la aplicación y descargar todas las dependencias.

Navegue al directorio raíz del proyecto (donde se encuentra el archivo `pom.xml`) y ejecute:

```bash
mvn clean install

Luego ubique la carpeta (**target**) y ejecute:

```bash
java -jar target/nombre-del-proyecto-0.0.1-SNAPSHOT.jar



🎉 Uso de Swagger UI
Abra su navegador y navegue a http://localhost:8081/meli/swagger-ui.html para ver la documentación interactiva generada por springdoc-openapi. Aquí podrá ver todos los endpoints documentados y probar las peticiones directamente.
