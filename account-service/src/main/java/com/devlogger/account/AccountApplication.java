package com.devlogger.account;

import com.devlogger.account.model.Account;
import com.devlogger.account.repositories.AccountRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author swop4a
 * @since 06/05/2018 17:32
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(AccountRepository repository) {
		return args -> {
			Account parent = Account.builder()
				.handle("swop4a")
				.username("Alexandr Pavkin")
				.company("EPAM")
				.facebook("https://www.facebook.com/")
				.gitHub("https://github.com/Swop4a")
				.skype("Swop4a")
				.telegram("@swop4a")
				.vk("http://vk.com/")
				.linkedIn("https://ru.linkedin.com/")
				.image("https://drive.google.com/file/d/1UmxUdPf-ClQk45pjGYJ7QKCV-8CpLfBE/view?usp=sharing")
				.interests(Arrays.asList("Java", "Spring", "Microservices"))
				.lastSeen(LocalDateTime.now())
				.postIds(Collections.singletonList("welcome-post"))
				.rating(BigDecimal.ONE)
				.since(LocalDate.now())
				.build();

			repository.save(parent);

			Account child = Account.builder()
				.handle("test")
				.username("Test Test")
				.company("Sbertech")
				.facebook("https://www.facebook.com/")
				.gitHub("https://github.com/test")
				.skype("Test")
				.telegram("@test")
				.vk("http://vk.com/")
				.linkedIn("https://ru.linkedin.com/")
				.image("https://drive.google.com/file/d/1UmxUdPf-ClQk45pjGYJ7QKCV-8CpLfBE/view?usp=sharing")
				.interests(Arrays.asList("Java", "Spring", "Microservices"))
				.lastSeen(LocalDateTime.now())
				.postIds(Collections.emptyList())
				.rating(BigDecimal.ZERO)
				.since(LocalDate.now())
				.following(Collections.singletonList(parent))
				.build();

			repository.save(child);
		};
	}
}
