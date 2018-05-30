package com.devlogger.post.model;

import com.devlogger.account.model.Account;
import com.fasterxml.jackson.annotation.JsonView;
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
	private Statistic statistic;
	private LocalDateTime publicationDate;
	private LocalDateTime lastUpdate;

	@JsonView(View.Full.class)
	private Account publisher;

	@JsonView(View.Preview.class)
	private String image;

}
