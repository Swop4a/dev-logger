package com.devlogger.post.services.impl;

import com.devlogger.post.model.Post;
import com.devlogger.post.repository.PostRepository;
import com.devlogger.post.services.PostService;
import java.util.List;
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

	@Autowired
	public PostServiceImpl(PostRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Post> findAllInPreviewMode() {
		//TODO: investigate rules, cut posts by this rules
		log.info("FIND ALL POSTS");
		return repository.findAll();
	}

	@Override
	public Post findPostById(String postId) {
		log.info("FIND POST WITH ID {}", postId);

		Post post = repository.findOne(postId);
		if (post == null) {
			log.warn("POST WITH ID {} NOT FOUND!", postId);
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
}
