package com.devlogger.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swop4a
 * @since 16/05/2018 19:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	private Comment parent;
	private String content;
}
