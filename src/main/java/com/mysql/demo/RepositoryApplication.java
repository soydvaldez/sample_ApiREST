package com.mysql.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplication
public class RepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class, args);
        RepositoryApplication.encoder();
    }

    static void encoder() {
		/*
		System.out.println("encoding text");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		String result = encoder.encode("myPassword");
		assertTrue(encoder.matches("myPassword", result));
		System.out.println("encoded text");*/
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/users/*").allowedOrigins("http://localhost:4200", "http://127.0.0.1:5500");
                registry.addMapping("/products/*").allowedOrigins("http://localhost:4200", "http://127.0.0.1:5500");
                registry.addMapping("/orders/*").allowedOrigins("http://localhost:4200", "http://127.0.0.1:5500");
            }
        };
    }
}