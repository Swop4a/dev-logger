package com.devlogger.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swop4a
 * @since 14/05/2018 14:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {

	private Long rating;
	private Long views;
	private Long downloads;
}
