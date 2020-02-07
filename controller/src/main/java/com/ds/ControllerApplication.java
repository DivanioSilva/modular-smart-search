package com.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ds.entities")
@EnableJpaRepositories
public class ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}

}
