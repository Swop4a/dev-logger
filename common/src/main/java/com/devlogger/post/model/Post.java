package com.devlogger.post.model;

import com.devlogger.account.model.Account;
import com.fasterxml.jackson.annotation.JsonView;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author swop4a
 * @since 02/05/2018 18:51
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "posts")
public class Post {

	@Id
	private String id;
	@NonNull
	private String title;
	@NonNull
	private List<String> tags;
	@NonNull
	private PostType type;
	@NonNull
	private String content;
	@NonNull
	private Statistic statistic;

	@NonNull
	private LocalDateTime publicationDate;

	@NonNull
	private LocalDateTime lastUpdate;

	@NonNull
	@JsonView(View.Full.class)
	private Account publisher;

	@NonNull
	@JsonView(View.Preview.class)
	private String image;

}
