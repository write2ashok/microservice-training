package com.fis.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@EnableEurekaClient
public class BookAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAPIApplication.class, args);
	}

}
