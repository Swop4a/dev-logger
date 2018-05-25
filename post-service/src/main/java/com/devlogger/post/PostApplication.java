package com.devlogger.post;

import com.devlogger.post.model.Account;
import com.devlogger.post.model.Post;
import com.devlogger.post.model.PostType;
import com.devlogger.post.model.Statistic;
import com.devlogger.post.repository.PostRepository;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

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

//	@Bean
//	public CommandLineRunner commandLineRunner(PostRepository repository) {
//		return args -> {
//			repository.deleteAll();
//			Post post = new Post();
//			post.setId("welcome-post");
//			post.setContent(
//				"\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.\"");
//			post.setImage("img");
//			post.setLastUpdate(LocalDateTime.now());
//			post.setPublicationDate(LocalDateTime.now());
//			post.setPublisher(new Account("Alexandr Pavkin", LocalDateTime.now()));
//			post.setStatistic(new Statistic(5L, 234L, 32L));
//			post.setTags(Arrays.asList("java", "microservices", "blog"));
//			post.setTitle("Welcome to Dev-logger post!");
//			post.setType(PostType.NEWS);
//
//			repository.save(post);
//		};
//	}
}
