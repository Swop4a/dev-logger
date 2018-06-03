package com.devlogger.post.services.impl;

import static com.devlogger.post.model.Tab.FEED;
import static com.devlogger.post.model.Tab.MY_POSTS;
import static com.devlogger.post.model.Tab.OWN_POSTS;

import com.devlogger.account.model.Account;
import com.devlogger.post.client.AccountServiceClient;
import com.devlogger.post.model.Post;
import com.devlogger.post.model.Tab;
import com.devlogger.post.repository.PostRepository;
import com.devlogger.post.services.PostService;
import com.devlogger.post.services.RangingService;
import com.devlogger.post.services.TextService;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author swop4a
 * @since 16/05/2018 12:14
 */
@Slf4j
@Service
public class PostServiceImpl implements PostService {

	private final PostRepository repository;
	private final AccountServiceClient client;
	private final TextService textService;
	private final RangingService rangingService;

	@Autowired
	public PostServiceImpl(PostRepository repository, AccountServiceClient client, TextService textService,
		RangingService rangingService) {
		this.repository = repository;
		this.client = client;
		this.textService = textService;
		this.rangingService = rangingService;
	}

	@Override
	public List<Post> findAllInPreviewMode(String handle, Tab tab, Boolean smart) {
		log.info("REQUEST FOR TAB {} AND SMART MODE IS {}", tab, smart);
		if (MY_POSTS.equals(tab)) {
			Account account = client.getAccountByName(handle);
			if (account == null) {
				log.error("ACCOUNT {} NOT FOUND");
				return Collections.emptyList();
			}

			List<String> followerHandles = getFollowerHandles(account);
			log.info("FOR ACCOUNT {} FOLLOWERS IDS {}", handle, followerHandles);
			List<Post> posts = repository.findAllByPublisherHandleInAndOrderByPublicationDateDesc(followerHandles);
			posts = convertToPreviewMode(posts);
			if (smart) {
				return rangingService.rank(posts, account);
			}

			return posts;
		}

		if (OWN_POSTS.equals(tab)) {
			List<Post> posts = repository.findAllByPublisherHandleAndOrderByPublicationDateDesc(handle);
			return convertToPreviewMode(posts);
		}

		if (FEED.equals(tab)) {
			List<Post> posts = repository.findAllByOrderByPublicationDateDesc();
			return convertToPreviewMode(posts);
		}

		log.error("UNSUPPORTED TAB {} AND SMART MODE IS {}", tab, smart);
		throw new UnsupportedOperationException("UNSUPPORTED OPERATION " + tab);
	}

	@Override
	public Post findPostById(String postId) {
		log.info("FIND POST WITH ID {}", postId);

		Post post = repository.findOne(postId);
		if (post == null) {
			log.warn("POST WITH ID {} NOT FOUND!", postId);
			return null;
		}

		log.info("POST {} RETRIEVED SUCCESSFULLY", post);

		return post;
	}

	@Override
	public Post add(Post post) {
		log.info("ADD POST {}", post);
		return repository.save(post);
	}

	@Override
	public Post updatePost(Post post) {
		log.info("UPDATE POST {}", post);
		return repository.save(post);
	}

	@Override
	public void deletePost(String postId) {
		log.info("DELETE POST {}", postId);
		repository.delete(postId);
	}

	private List<Post> convertToPreviewMode(List<Post> posts) {
		return posts.stream()
			.peek(post -> {
				String content = post.getContent();
				String previewContent = textService.toPreview(content);
				post.setContent(previewContent);
			})
			.collect(Collectors.toList());
	}

	private List<String> getFollowerHandles(Account account) {
		return account.getFollowers().stream()
			.map(Account::getHandle)
			.collect(Collectors.toList());
	}
}
