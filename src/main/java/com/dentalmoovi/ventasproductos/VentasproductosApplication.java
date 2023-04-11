package com.dentalmoovi.ventasproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class VentasproductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasproductosApplication.class, args);
	}

}
