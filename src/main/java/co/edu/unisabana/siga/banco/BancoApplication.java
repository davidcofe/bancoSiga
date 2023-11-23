package co.edu.unisabana.siga.banco;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@OpenAPIDefinition(info = @Info(title = "Banco Siga", version = "1.0", description = "Proyecto de Diseño y Arquitectura de Software para la creacion de un banco para Siga, creado por: David Corzo, Luis Angle Bernal y Jorge Anaya"))
public class BancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

}
