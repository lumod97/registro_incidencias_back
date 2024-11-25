package com.cpiura.catics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CaticsApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CaticsApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(
						"http://localhost:4200")
				.allowedMethods(
						"GET",
						"PUT",
						"POST",
						"DELETE",
						"PATCH",
						"OPTIONS");
	}

}
