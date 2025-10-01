package com.challenge.meli;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Detalle Productos MELI", version = "v1.0", description = "API RESTful desarrollada con Spring Boot para gestionar y consultar un catálogo de productos inspirada en MeLI"))
public class MeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeliApplication.class, args);
	}

}
