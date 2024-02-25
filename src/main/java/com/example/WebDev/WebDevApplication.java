package com.example.WebDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebDevApplication.class, args);
	}

}
