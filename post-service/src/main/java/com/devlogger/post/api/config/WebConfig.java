package com.devlogger.post.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author swop4a
 * @since 20/05/2018 16:58
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("POST", "GET", "OPTIONS", "DELETE")
			.maxAge(3600)
			.exposedHeaders("x-requested-with");
	}
}
