package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SorapiApplication {

	public static void main(String[] args) {
		//Launch application with http://localhost:8080/swagger-ui/index.html#
		SpringApplication.run(SorapiApplication.class, args);
	}

}
