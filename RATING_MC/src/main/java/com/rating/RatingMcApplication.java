package com.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingMcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingMcApplication.class, args);
	}

}
