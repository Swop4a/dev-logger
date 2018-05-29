package com.devlogger.rest;

import com.devlogger.account.model.Account;

/**
 * @author swop4a
 * @since 27/05/2018 17:39
 */
public interface AccountControllerInterface {

	Account getAccountByName(String handle);

	Account createNewAccount(Account account);
}
