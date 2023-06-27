package com.rosie.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rosie")
public class FirstRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestApiApplication.class, args);
	}

}
