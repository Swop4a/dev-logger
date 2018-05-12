package com.devlogger.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author swop4a
 * @since 02/05/2018 18:47
 */
@Controller
//@EnableDiscoveryClient
@SpringBootApplication
public class PostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}

	@ApiIgnore
	@GetMapping("/")
	public String swagger() {
		return "redirect:swagger-ui.html";
	}
}
