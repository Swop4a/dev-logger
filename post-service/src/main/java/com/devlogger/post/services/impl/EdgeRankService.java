package com.devlogger.post.services.impl;

import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.sqrt;

import com.devlogger.account.model.Account;
import com.devlogger.account.model.Favorite;
import com.devlogger.post.model.Comment;
import com.devlogger.post.model.Like;
import com.devlogger.post.model.Post;
import com.devlogger.post.services.RangingService;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

/**
 * @author swop4a
 * @since 30/05/2018 20:40
 */
@Slf4j
@Service
public class EdgeRankService implements RangingService {

	private static final double BASE_SCORE = 0.01;
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

		double likesLog = log(calculateLikesOfPublisherPosts(account, publisher) + 1);
		double mutualContacts = calculateMutualAccounts(account, publisher);
		double mutualInterests = calculateMutualInterests(account, publisher);

		return likesLog * mutualContacts * mutualInterests;
	}

	/**
	 * Method calculate number metric of following points:
	 * - Number of likes for post
	 * - Number of comments
	 */
	private double weight(Post post, Account account) {
		double postLikesLog10 = log10(calculatePostLikes(post) + 1);
		double commentsCountLog10 = log10(calculateCommentsCount(post) + 1);
		double userCommentsCountLn = sqrt(calculateUserCommentsCount(post, account) + 1);

		return postLikesLog10 * commentsCountLog10 * userCommentsCountLn;
	}

	/**
	 * Method calculate the metric of "fresh" of the post.
	 */
	private double decay(Post post) {
		return 1;
	}

	private double calculateUserCommentsCount(Post post, Account account) {
		List<Like> likes;
		if (CollectionUtils.isEmpty(likes = post.getLikes())) {
			return BASE_SCORE;
		}
		return likes.stream()
			.map(Like::getHandle)
			.filter(handle -> handle.equals(account.getHandle()))
			.count();
	}

	private double calculatePostLikes(Post post) {
		List<Like> likes = post.getLikes();
		if (CollectionUtils.isEmpty(likes)) {
			return BASE_SCORE;
		}
		return likes.size();
	}

	private static double calculateCommentsCount(Post post) {
		List<Comment> comments = post.getComments();
		if (CollectionUtils.isEmpty(comments)) {
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

		if (CollectionUtils.isEmpty(favorites)) {
			return BASE_SCORE;
		}

		long likes = favorites.stream()
			.filter(favorite -> favorite.getAccounts() != null && favorite.getAccounts().contains(publisher))
			.filter(favorite -> lastMonth.isBefore(favorite.getTime().toLocalDate()))
			.count();
		double likesOfPublisherPosts = likes / (double) favorites.size();

		return likesOfPublisherPosts == 0 ? BASE_SCORE : likesOfPublisherPosts;
	}

	private double calculateMutualAccounts(Account account, Account publisher) {
		return calculateMutualPart(account, publisher, Account::getFollowing);
	}

	private double calculateMutualInterests(Account account, Account publisher) {
		return calculateMutualPart(account, publisher, Account::getInterests);
	}

	private double calculateMutualPart(Account account, Account publisher, Function<Account, List> accessFunction) {
		List accountList = accessFunction.apply(account);
		List publisherList = accessFunction.apply(publisher);

		if (CollectionUtils.isEmpty(accountList) || CollectionUtils.isEmpty(accountList)) {
			return BASE_SCORE;
		}

		Collection intersection = CollectionUtils.intersection(accountList, publisherList);
		Collection union = CollectionUtils.union(accountList, publisherList);

		double mutualParts = intersection.size() / (double) union.size();

		return mutualParts == 0 ? BASE_SCORE : mutualParts;
	}
}