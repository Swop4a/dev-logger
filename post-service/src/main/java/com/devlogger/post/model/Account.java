package com.devlogger.post.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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

	private Long id;
	private String username;
	private String image;
	private String company;
	private BigDecimal rating;
	private List<String> interests;
	private List<Account> followers;
	private List<Account> following;
	private List<String> postIds;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDate since;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime lastSeen;

	private String skype;
	private String gitHub;
	private String telegram;
	private String facebook;
	private String vk;
}
