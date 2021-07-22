package com.example.application;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * 
 * @author harmand 'AirFranceTestApplication', to run my spring boot application
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.repository"})
@ComponentScan(basePackages = { "com.example.service", "com.example.controllerRest" })
@EntityScan(basePackages = {"com.example.model"})

public class AirFranceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirFranceTestApplication.class, args);
	}

}
