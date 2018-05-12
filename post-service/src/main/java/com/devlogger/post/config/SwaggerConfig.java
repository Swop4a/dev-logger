package com.devlogger.post.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author swop4a
 * @since 02/05/2018 18:50
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	@Value("${app.version}")
	private String version;

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage("com.devlogger.post"))
			.build()
			.apiInfo(apiInfo());
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("API provide operations for posts manipulation")
			.version(version)
			.contact(
				new Contact("Alexandr Pavkin",
					"https://github.com/Swop4a",
					"alexandr300896@gmail.com"))
			.build();
	}

}
