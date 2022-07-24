package com.greatlearning.employee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// Swagger Builder code for the application
	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiIndo()).groupName("Employee-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.employee.controller")).build();
	}

	private ApiInfo apiIndo() {
		return new ApiInfoBuilder().title("Employee Developer Documnet").description("DEv Docs for Employee")
				.termsOfServiceUrl("http:/lib.com").license("Employee blicense").licenseUrl("http:/lib.com")
				.version("1.0.0").build();
	}

}
