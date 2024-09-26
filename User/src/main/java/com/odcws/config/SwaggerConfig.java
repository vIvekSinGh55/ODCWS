package com.odcws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI myCustomConfig()
	{
		return new OpenAPI().info(
				
				new Info().title("ODCWS User Microservice APIs")
							.description("By learner")
		);
	}

}
