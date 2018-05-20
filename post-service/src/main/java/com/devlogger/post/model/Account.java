package com.devlogger.post.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime lastSeen;
}
