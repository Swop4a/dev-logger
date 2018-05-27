package com.devlogger.account.repositories;

import com.devlogger.account.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * @author swop4a
 * @since 21/05/2018 23:52
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByHandle(String name);

	void deleteAccountByHandle(String name);
}
