package com.devlogger.post.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swop4a
 * @since 30/05/2018 23:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Like {

	private String handle;
	private LocalDateTime time;
}
