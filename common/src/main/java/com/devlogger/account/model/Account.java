package com.devlogger.account.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author swop4a
 * @since 21/05/2018 23:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"followers", "following", "favorites"})
@ToString(exclude = {"followers", "following", "favorites"})
@Builder
@Entity
@Table(name = "accounts", uniqueConstraints = {@UniqueConstraint(columnNames = "handle")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "handle")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	private String handle;
	private String username;
	private String image;
	private String company;
	private BigDecimal rating;

	@ElementCollection
	@CollectionTable(name = "interests", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "interest")
	private List<String> interests;

	@JsonIgnore
	@ElementCollection
	@CollectionTable(name = "post_ids", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "postId")
	private List<String> postIds;

	@ManyToMany
	@JoinTable(name = "followers_following",
		joinColumns = @JoinColumn(name = "following_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "followers_id", referencedColumnName = "id")
	)
	private List<Account> followers;

	@ManyToMany
	@JoinTable(name = "followers_following",
		joinColumns = @JoinColumn(name = "followers_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "following_id", referencedColumnName = "id")
	)
	private List<Account> following;

	@ManyToMany
	@JoinTable(name = "accounts_favorites",
		joinColumns = @JoinColumn(name = "id"),
		inverseJoinColumns = @JoinColumn(name = "post_id")
	)
	private List<Favorite> favorites;

//	@JsonSerialize(using = ToStringSerializer.class)
//	private LocalDate since;

//	@JsonSerialize(using = ToStringSerializer.class)
//	private LocalDateTime lastSeen;

	private String skype;
	private String gitHub;
	private String telegram;
	private String facebook;
	private String vk;
	private String linkedIn;
}
