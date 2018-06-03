package com.devlogger.account.services;

import com.devlogger.account.model.Account;

/**
 * @author swop4a
 * @since 21/05/2018 23:50
 */
public interface AccountService {

	Account getAccountByHandle(String handle);

	Account updateAccount(String handle, Account account);

	Account createAccount(Account account);
}
