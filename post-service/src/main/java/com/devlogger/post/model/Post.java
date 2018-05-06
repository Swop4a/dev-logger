package com.devlogger.post.model;

import java.time.LocalDate;
import lombok.Data;

/**
 * @author swop4a
 * @since 02/05/2018 18:51
 */
@Data
public class Post {

	private Long postId;
	private String title;
	private PostType type;
	private String content;
	private LocalDate creationDate;
	private int rating;

	public enum PostType {
		TEXT, PODCAST;
	}
}
