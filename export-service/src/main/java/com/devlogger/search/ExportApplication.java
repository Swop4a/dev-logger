package com.devlogger.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author swop4a
 * @since 06/05/2018 17:36
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ExportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExportApplication.class, args);
	}
}
