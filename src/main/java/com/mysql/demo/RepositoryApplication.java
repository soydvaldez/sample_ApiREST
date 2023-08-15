package com.mysql.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplication
public class RepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
		RepositoryApplication.encoder();
	}
	static void encoder(){
		/*
		System.out.println("encoding text");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		String result = encoder.encode("myPassword");
		assertTrue(encoder.matches("myPassword", result));
		System.out.println("encoded text");*/
	}
}