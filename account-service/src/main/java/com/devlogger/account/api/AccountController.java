package com.devlogger.account.api;

import com.devlogger.account.model.Account;
import com.devlogger.account.services.AccountService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swop4a
 * @since 21/05/2018 23:51
 */
@RestController
public class AccountController {

	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(path = "/{handle}", method = RequestMethod.GET, produces = "application/json")
	public Account getAccountByName(@PathVariable String handle) {
		return accountService.getAccountByHandle(handle);
	}

	@RequestMapping(path = "/current", method = RequestMethod.GET, produces = "application/json")
	public Account getCurrentAccount(Principal principal) {
		return accountService.getAccountByHandle(principal.getName());
	}

	@RequestMapping(path = "/current", method = RequestMethod.PUT, consumes = "application/json")
	public void saveCurrentAccount(Principal principal, @RequestBody Account account) {
		accountService.updateAccount(principal.getName(), account);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST, produces = "application/json")
	public Account createNewAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
}
