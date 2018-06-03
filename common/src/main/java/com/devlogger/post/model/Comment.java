package com.devlogger.post.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swop4a
 * @since 16/05/2018 19:03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	private String author;
	private Comment parent;
	private List<Comment> childes;
	private String content;
}
