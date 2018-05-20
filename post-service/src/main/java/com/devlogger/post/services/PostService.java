package com.devlogger.post.services;

import com.devlogger.post.model.Post;
import com.devlogger.post.model.Tab;
import java.util.List;

/**
 * @author swop4a
 * @since 02/05/2018 18:52
 */
public interface PostService {

	List<Post> findAllInPreviewMode(Tab tab, Boolean smart);

	Post findPostById(String postId);

	Post add(Post post);

	Post updatePost(Post post);

	void deletePost(String postId);
}
