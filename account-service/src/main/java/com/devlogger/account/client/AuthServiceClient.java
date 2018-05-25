package com.devlogger.account.client;

import com.devlogger.account.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author swop4a
 * @since 21/05/2018 23:55
 */
@FeignClient(name = "auth-service")
public interface AuthServiceClient {

	@RequestMapping(value = "/auth/createUser", method = RequestMethod.POST, consumes = "application/json")
	void createUser(User user);
}
