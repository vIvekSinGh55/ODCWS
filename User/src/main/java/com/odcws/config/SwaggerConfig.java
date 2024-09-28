package com.odcws.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI myCustomConfig()
	{
		return new OpenAPI()
				.info(
				new Info().title("ODCWS User Microservice APIs")
							.description("By learner")
				)
				
				.servers(List.of(new Server().url("http://localhost:8081").description("Local")));
				
	}

}
