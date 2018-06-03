package com.devlogger.post.services;

import com.devlogger.account.model.Account;
import com.devlogger.post.model.Post;
import java.util.List;

/**
 * @author swop4a
 * @since 30/05/2018 20:40
 */
public interface RangingService {

	List<Post> rank(List<Post> publications, Account account);
}
