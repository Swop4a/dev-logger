package com.devlogger.post.client;

import com.devlogger.account.model.Account;
import com.devlogger.rest.AccountControllerInterface;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author swop4a
 * @since 27/05/2018 20:17
 */
@FeignClient("account-service")
public interface AccountServiceClient extends AccountControllerInterface {

	@Override
	@RequestMapping(value = "/accounts/{handle}", method = RequestMethod.GET, produces = "application/json")
	Account getAccountByName(@PathVariable("handle") String handle);

	@Override
	@RequestMapping(value = "/accounts/", method = RequestMethod.POST, produces = "application/json")
	Account createNewAccount(@RequestBody Account account);
}
