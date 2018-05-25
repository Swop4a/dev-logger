package com.devlogger.account.services.impl;

import com.devlogger.account.model.Account;
import com.devlogger.account.repositories.AccountRepository;
import com.devlogger.account.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author swop4a
 * @since 21/05/2018 23:51
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository repository;

	@Autowired
	public AccountServiceImpl(AccountRepository repository) {
		this.repository = repository;
	}

	@Override
	public Account getAccountByHandle(String handle) {
		log.info("RETRIEVING ACCOUNT WITH HANDLE {}", handle);

		Account account = repository.findByHandle(handle);
		if (account == null) {
			log.warn("ACCOUNT {} IS EMPTY", handle);
			return null;
		}

		log.info("ACCOUNT {} RETRIEVED SUCCESSFULLY", account);

		return account;
	}

	@Override
	@Transactional
	public Account updateAccount(String handle, Account account) {
		log.info("UPDATING ACCOUNT WITH HANDLE {}", handle);
		if (!handle.equals(account.getHandle())) {
			repository.deleteAccountByHandle(handle);
		}
		return repository.save(account);
	}

	@Override
	public Account createAccount(Account account) {
		return repository.save(account);
	}
}
