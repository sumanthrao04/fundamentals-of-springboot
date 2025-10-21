package com.sumanth.fundamentals_of_springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Fundamentals of Spring boot projects",
                description = "learning springboot core concepts by building small demo projects",
                version = "V1.0",
                contact = @Contact(
                        name = "sumanth Parashuram",
                        email = "Sumanth@gmail.com",
                        url = "https://github.com/sumanthrao04"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Git hub repository for the fundamentals of springboot",
                url = "https://github.com/sumanthrao04"
        )
)
public class FundamentalsOfSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsOfSpringbootApplication.class, args);
	}

}
