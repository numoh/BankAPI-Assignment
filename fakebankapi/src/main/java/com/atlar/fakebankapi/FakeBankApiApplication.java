package com.atlar.fakebankapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
@OpenAPIDefinition(
    info = @Info(
        title = "Faker Bank API",
        version = "1.0.0",
        description = "API for faker Bank",
        termsOfService = "none for now"
    )
)
public class FakeBankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeBankApiApplication.class, args);
	}

    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder()
            .group("Faker_Bank_APIs")
            .pathsToMatch(
                "/transactions/**",
                "/accounts/**")
            .build();
    }

}
