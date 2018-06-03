package com.devlogger.post.model;

import com.devlogger.account.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author swop4a
 * @since 02/05/2018 18:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "posts")
public class Post {

	@Id
	private String id;
	private String title;
	private List<String> tags;
	private PostType type;
	private String content;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDate publicationDate;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime lastUpdate;

	@JsonView(View.Full.class)
	private Account publisher;

	@JsonView(View.Preview.class)
	private String image;

	@JsonIgnore
	private List<Like> likes;

	private List<Comment> comments;

	@JsonProperty("rating")
	public int getRating() {
		return likes == null ? 0 : likes.size();
	}

	@JsonProperty("commentsCount")
	public int getCommentsCount() {
		return comments == null ? 0 : comments.size();
	}
}
