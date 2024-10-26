package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableOpenApi
public class BookMyCineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyCineApplication.class, args);
	}

}
// test
// http://localhost:8080/swagger-ui/index.html