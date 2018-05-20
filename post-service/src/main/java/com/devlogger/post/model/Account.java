package com.devlogger.post.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swop4a
 * @since 14/05/2018 13:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	private String name;
	private LocalDateTime lastSeen;
}
