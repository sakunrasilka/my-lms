package com.example.backend;

import com.example.WelcomeRunner;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableMongoAuditing
@SpringBootApplication
public class BackendApplication {

	@Bean
	public ApplicationRunner welcomeRunner() {
		return new WelcomeRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
