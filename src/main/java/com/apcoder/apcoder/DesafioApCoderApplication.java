package com.apcoder.apcoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Desafio ApCoders!", description = "Gerenciador de condomínios."))
@SpringBootApplication
public class DesafioApCoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApCoderApplication.class, args);
	}

}
