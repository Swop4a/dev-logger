package com.devlogger.account.client;

import com.devlogger.account.model.Post;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author swop4a
 * @since 22/05/2018 09:15
 */
@FeignClient(name = "post-service")
public interface PostServiceClient {

	@RequestMapping(value = "/posts", method = RequestMethod.GET, produces = "application/json")
	List<Post> getPosts();
}
