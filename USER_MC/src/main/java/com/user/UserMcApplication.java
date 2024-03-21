package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableWebMvc
//@EnableCaching
public class UserMcApplication {
//	Pagination applied on it...

	public static void main(String[] args) {
		SpringApplication.run(UserMcApplication.class, args);
	}

}
