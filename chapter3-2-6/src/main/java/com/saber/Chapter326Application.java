package com.saber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Chapter326Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter326Application.class, args);
	}
}
