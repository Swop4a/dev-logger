package com.devlogger.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swop4a
 * @since 31/05/2018 12:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "favorites")
@Entity
public class Favorite {

	@Id
	private String postId;

	@JsonIgnore
	@ManyToMany(mappedBy = "favorites")
	private List<Account> accounts;

	@JsonSerialize(using = ToStringSerializer.class)
	private Date time;
}
