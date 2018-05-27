package com.devlogger.post.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

	@JsonSerialize(using = ToStringSerializer.class)
	@NonNull
	private LocalDateTime publicationDate;

	@JsonSerialize(using = ToStringSerializer.class)
	@NonNull
	private LocalDateTime lastUpdate;

	@NonNull
	@JsonView(View.Full.class)
	private Account publisher;

	@NonNull
	@JsonView(View.Preview.class)
	private String image;

}
