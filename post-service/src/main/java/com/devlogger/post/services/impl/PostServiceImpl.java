package com.devlogger.post.services.impl;

import static com.devlogger.post.model.Tab.FEED;
import static com.devlogger.post.model.Tab.MY_POSTS;

import com.devlogger.post.client.AccountServiceClient;
import com.devlogger.post.model.Account;
import com.devlogger.post.model.Post;
import com.devlogger.post.model.Tab;
import com.devlogger.post.repository.PostRepository;
import com.devlogger.post.services.PostService;
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

	//TODO extract this to proprties file
	private static final Integer LIMIT = 1500;
	private static final String NEW_PARAGRAPH = "\n\n";
	private static final char DOT = '.';

	private final PostRepository repository;
	private final AccountServiceClient client;

	@Autowired
	public PostServiceImpl(PostRepository repository, AccountServiceClient client) {
		this.repository = repository;
		this.client = client;
	}

	@Override
	public List<Post> findAllInPreviewMode(String name, Tab tab, Boolean smart) {
		log.info("REQUEST FOR TAB {} AND SMART MODE IS {}", tab, smart);

		if (MY_POSTS.equals(tab)) {
			Account account = client.getAccountByName(name);
			if (account == null) {
				throw new RuntimeException("User not found");
			}

			List<Long> ids = getFollowerIds(account);
			if (smart) {
				//TODO: it means that "show ONLY FOLLOWING'S posts with smart=true, delegate to other service"
				return repository.findAll();
			} else {
				return repository.findAllByPublisherIdInAndOrderByPublicationDateDesc(ids).stream()
					.peek(post -> {
						String content = post.getContent();
						String previewContent = getPreviewContent(content);
						post.setContent(previewContent);
					})
					.collect(Collectors.toList());
			}
		}

		if (FEED.equals(tab)) {
			//TODO: it means that "show ALL INTERESTING posts with smart=true, delegate to other service"
			return repository.findAll();
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

	private String getPreviewContent(String content) {
		content = removeImagesFromContent(content);
		content = normalizeContent(content);
		content = content.substring(0, Math.min(content.length(), LIMIT));

		int indexOfNewParagraph = content.lastIndexOf(NEW_PARAGRAPH);
		int indexOfLastDot = content.lastIndexOf(DOT);

		if (indexOfNewParagraph > indexOfLastDot) {
			return content.substring(0, Math.max(0, indexOfNewParagraph));
		} else {
			return content.substring(0, Math.max(0, indexOfLastDot));
		}
	}

	private List<Long> getFollowerIds(Account account) {
		return account.getFollowers().stream()
			.map(Account::getId)
			.collect(Collectors.toList());
	}

	private String normalizeContent(String content) {
		//TODO remove all <h1>, <p> etc...
		return content;
	}

	private String removeImagesFromContent(String content) {
		//TODO remove all images by regexp
		return content;
	}
}
