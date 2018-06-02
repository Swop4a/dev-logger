package com.devlogger.post;

import com.devlogger.post.api.converters.UtilDateToSQLDateConverter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

/**
 * @author swop4a
 * @since 02/05/2018 18:47
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}

	@Bean
	public CustomConversions customConversions() {
		List<Converter<?, ?>> converterList = new ArrayList<>();
		converterList.add(new UtilDateToSQLDateConverter());
		return new CustomConversions(converterList);
	}
}
