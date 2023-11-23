package com.example_projec.SpringbootSwegger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@EntityScan("com.example_projec.SpringbootSwegger.models")
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Project API (AKADEMIK)",
				version = "1.0.0",
				description = "This project is only for Learning!",
				termsOfService = "anton-alifandi",
				contact = @Contact(
						name = "Anton Alifandi",
						email = "alifandianton20@gmail.com"
				),
				license = @License(
						name = "licence",
						url = "anton-alifandi"
				)
		)
)
public class SpringbootSweggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSweggerApplication.class, args);
	}

}
