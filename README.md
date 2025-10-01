# meli-challenge
This is a project created on challenge MELI, Applying to Software Developer IA

📦 API de Catálogo de Productos (Mercado Libre Challenge)
Esta es una API RESTful desarrollada con Spring Boot para gestionar y consultar un catálogo de productos, implementando el patrón de Arquitectura Hexagonal (Ports and Adapters) para desacoplar la lógica de negocio de los detalles técnicos (persistencia en JSON).

🚀 Tecnologías
Lenguaje: Java 21
Framework: Spring Boot 3.5.6
Herramientas: Lombok (para modelos limpios), Maven (gestor de dependencias).
Pruebas: JUnit 5 y Mockito.

🛠️ Instalación y Ejecución
Clonar el Repositorio:
git clone https://github.com/leyder154611/meli-challenge

Requerimiento de JDK 21:
Esta aplicación debe ejecutarse con Java Development Kit (JDK) versión 21.
Si no lo tienes, puedes obtener una distribución compatible, por ejemplo, Azul Zulu aquí.

Ejecutar la Aplicación (Directo con JAR):
El JAR ejecutable se encuentra en la ruta /deployment/meli.jar dentro del proyecto.

# Asegúrate de estar en el directorio donde se encuentra el JAR.
cd deployment 

# Ejecutar la aplicación con el comando java -jar
java -jar meli.jar

La aplicación estará disponible en http://localhost:8081.

📌 Endpoints de la API
La base de la API es /meli/api/products.

GET
http://localhost:8081/meli/api/products
Retorna el listado completo de los 20 productos del catálogo.

GET
http://localhost:8081/meli/api/products/{id}
Retorna los detalles de un producto por su ID.

🧪 Ejecución de Pruebas Unitarias
Para asegurar la integridad de la Arquitectura Hexagonal, ejecuta la suite completa de tests:

mvn test

Esto validará la lógica del Servicio y la lectura del Adaptador de Persistencia.
