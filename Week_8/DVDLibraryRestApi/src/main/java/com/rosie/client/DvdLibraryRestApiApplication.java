package com.rosie.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rosie")
public class DvdLibraryRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdLibraryRestApiApplication.class, args);
	}

}
