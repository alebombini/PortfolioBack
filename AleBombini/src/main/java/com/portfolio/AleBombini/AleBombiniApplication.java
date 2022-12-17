package com.portfolio.AleBombini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.portfolio.AleBombini")
public class AleBombiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(AleBombiniApplication.class, args);
	}

}
