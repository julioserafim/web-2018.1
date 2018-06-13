package com.ufc.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CrudSpringboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringboot2Application.class, args);
		System.out.println("Password: " + new BCryptPasswordEncoder().encode("123"));
	}
}
