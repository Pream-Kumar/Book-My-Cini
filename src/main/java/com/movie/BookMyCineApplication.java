package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class BookMyCineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyCineApplication.class, args);
	}

}