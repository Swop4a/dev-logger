package com.devlogger.post.client;

import com.devlogger.post.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author swop4a
 * @since 24/05/2018 13:27
 */
@FeignClient(name = "account-service")
public interface AccountServiceClient {

	@RequestMapping(path = "/accounts/{name}", method = RequestMethod.GET, produces = "application/json")
	Account getAccountByName(@PathVariable String name);
}
