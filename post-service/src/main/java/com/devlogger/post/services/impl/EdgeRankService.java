package com.devlogger.post.services.impl;

import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.apache.commons.collections4.CollectionUtils.intersection;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import com.devlogger.account.model.Account;
import com.devlogger.account.model.Favorite;
import com.devlogger.post.model.Comment;
import com.devlogger.post.model.Like;
import com.devlogger.post.model.Post;
import com.devlogger.post.services.RangingService;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author swop4a
 * @since 30/05/2018 20:40
 */
@Slf4j
@Service
public class EdgeRankService implements RangingService {

	private static final double BASE_SCORE = 0.3;
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("##0.000000000");

	@Override
	public List<Post> rank(List<Post> publications, Account account) {
		log.info("========================== EDGE RANK INFO ==========================");
		List<Post> rankedPosts = publications.stream()
			.collect(Collectors.toMap(Function.identity(), post -> awd(post, account)))
			.entrySet()
			.stream()
			.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
			.map(Entry::getKey)
			.collect(Collectors.toList());
		log.info("=====================================================================");
		return rankedPosts;
	}

	private Double awd(Post post, Account account) {
		double affinity = affinity(post, account);
		double weight = weight(post, account);
		double decay = decay(post);

		double awd = affinity * weight * decay;

		log.info("EdgeRank {} FOR POST {} WITH AFFINITY={}, WIGHT={}, DECAY={}", DECIMAL_FORMAT.format(awd),
			post.getId(), DECIMAL_FORMAT.format(affinity), DECIMAL_FORMAT.format(weight), DECIMAL_FORMAT.format(decay));
		return awd;
	}

	/**
	 * Method calculate number metrics of the following points:
	 * - How much posts of publisher user liked
	 * - How many followers/followings are same
	 * - How many interesting are same
	 */
	private double affinity(Post post, Account account) {
		Account publisher = post.getPublisher();

		double likesLog = log10(calculateLikesOfPublisherPosts(account, publisher) + 1);
		double mutualContacts = log10(calculateMutualAccounts(account, publisher) + 1);
		double mutualInterests = log10(calculateMutualInterests(account, publisher) + 1);

		return likesLog * mutualContacts * mutualInterests;
	}

	/**
	 * Method calculate number metric of following points:
	 * - Number of likes for post
	 * - Number of comments
	 */
	private double weight(Post post, Account account) {
		double postLikesLog = log(calculatePostLikes(post) + 1) * 1.5;
		double commentsCountLog = log(calculateCommentsCount(post) + 1);
		double userImpact = calculateUserImpact(post, account);
		double tagRelevance = tagRelevance(post, account);

		return postLikesLog * commentsCountLog * userImpact * tagRelevance;
	}

	/**
	 * Method calculate the metric of "fresh" of the post.
	 */
	private double decay(Post post) {
		LocalDate publicationDate = post.getPublicationDate();
		return timeFunction(publicationDate);
	}

	private double tagRelevance(Post post, Account account) {
		List<String> tags = post.getTags();
		List<String> interests = account.getInterestList();

		if (isEmpty(tags) || isEmpty(interests)) {
			return 1;
		}

		int counter = 0;

		for (String tag : tags) {
			for (String interest : interests) {
				counter += tag.equalsIgnoreCase(interest) ? 1 : 0;
			}
		}

		return counter == 0 ? 1 : counter;
	}

	private double timeFunction(LocalDate date) {
		long timeDelta = LocalDate.now().toEpochDay() - date.toEpochDay();

		if (timeDelta >= 0 && timeDelta <= 1) {
			return sqrt(timeDelta) + BASE_SCORE;
		} else if (timeDelta >= 2 && timeDelta <= 4) {
			return 1;
		} else {
			return 1 / pow(timeDelta, 2);
		}
	}

	private double calculateUserImpact(Post post, Account account) {
		double userCommentsCount = log(calculateUserCommentsCount(post, account) + 1) * 4;
		double userLikesCount = log(calculateUserLikesCount(post, account) + 1) * 2;

		double impact = userCommentsCount + userLikesCount;

		return impact == 0 ? BASE_SCORE : impact;
	}

	private double calculateUserCommentsCount(Post post, Account account) {
		return Optional.ofNullable(post.getComments())
			.orElse(Collections.emptyList()).stream()
			.map(Comment::getAuthor)
			.filter(author -> author.equals(account.getHandle()))
			.count();
	}

	private double calculateUserLikesCount(Post post, Account account) {
		return Optional.ofNullable(post.getLikes())
			.orElse(Collections.emptyList()).stream()
			.map(Like::getHandle)
			.filter(handle -> handle.equals(account.getHandle()))
			.count();
	}

	private double calculatePostLikes(Post post) {
		List<Like> likes = post.getLikes();
		if (isEmpty(likes)) {
			return BASE_SCORE;
		}
		return likes.size();
	}

	private static double calculateCommentsCount(Post post) {
		List<Comment> comments = post.getComments();
		if (isEmpty(comments)) {
			return BASE_SCORE;
		}
		return calculateCommentsCount(comments, 0);
	}

	private static double calculateCommentsCount(List<Comment> comments, int count) {
		for (Comment comment : comments) {
			List<Comment> childes = comment.getChildes();
			if (childes != null) {
				count += calculateCommentsCount(childes, 1);
			} else {
				count++;
			}
		}
		return count;
	}

	private double calculateLikesOfPublisherPosts(Account account, Account publisher) {
		LocalDate lastMonth = LocalDate.now().minusMonths(1L);
		List<Favorite> favorites = account.getFavorites();
		List<String> postIds = publisher.getPostIds();

		if (isEmpty(favorites) || isEmpty(postIds)) {
			return BASE_SCORE;
		}

		long likes = favorites.stream()
			.filter(Objects::nonNull)
			.filter(favorite -> lastMonth.isBefore(favorite.getTime().toLocalDate()))
			.map(Favorite::getPostId)
			.filter(postIds::contains)
			.count();

		return likes == 0 ? BASE_SCORE : likes;
	}

	private double calculateMutualAccounts(Account account, Account publisher) {
		return calculateMutualPart(account, publisher, Account::getFollowing);
	}

	private double calculateMutualInterests(Account account, Account publisher) {
		return calculateMutualPart(account, publisher, Account::getInterestList);
	}

	private double calculateMutualPart(Account account, Account publisher, Function<Account, List> accessFunction) {
		List accountList = accessFunction.apply(account);
		List publisherList = accessFunction.apply(publisher);

		if (isEmpty(accountList) || isEmpty(accountList)) {
			return BASE_SCORE;
		}

		int intersectionSize = intersection(accountList, publisherList).size();

		return intersectionSize == 0 ? BASE_SCORE : intersectionSize;
	}
}