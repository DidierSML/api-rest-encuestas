package com.api.rest.apirestencuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ApiRestEncuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestEncuestasApplication.class, args);
	}

}
