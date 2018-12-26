package com.rokomari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
@EnableAutoConfiguration
public class ResTfulInPeaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulInPeaceApplication.class, args);
	}

}
