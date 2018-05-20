package com.devlogger.post.api.controllers;

import com.devlogger.post.model.Post;
import com.devlogger.post.model.Tab;
import com.devlogger.post.model.View;
import com.devlogger.post.services.PostService;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swop4a
 * @since 02/05/2018 18:52
 */
@RestController
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@JsonView(View.Preview.class)
	@RequestMapping(path = "/getPosts", method = RequestMethod.GET, produces = "application/json")
	public List<Post> getPosts(@RequestParam Tab tab, @RequestParam Boolean smart) {
		return postService.findAllInPreviewMode(tab, smart);
	}

	@JsonView(View.Full.class)
	@RequestMapping(path = "/getPost/{postId}", method = RequestMethod.GET, produces = "application/json")
	public Post getPost(@PathVariable String postId) {
		return postService.findPostById(postId);
	}

	@JsonView(View.Full.class)
	@RequestMapping(path = "/createPost", method = RequestMethod.POST, produces = "application/json")
	public Post add(@RequestBody Post post) {
		return postService.add(post);
	}

	@JsonView(View.Full.class)
	@RequestMapping(path = "/updatePost", method = RequestMethod.PUT, produces = "application/json")
	public Post updatePost(@RequestBody Post post) {
		return postService.updatePost(post);
	}

	@RequestMapping(path = "/deletePost", method = RequestMethod.DELETE, produces = "application/json")
	public void deletePost(@PathVariable String postId) {
		postService.deletePost(postId);
	}
}
