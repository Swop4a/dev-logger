package com.devlogger.post.model;

import static java.util.stream.Collectors.toMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

/**
 * @author swop4a
 * @since 20/05/2018 17:54
 */
public enum Tab {
	FEED, MY_POSTS, OWN_POSTS;

	private static final Map<String, Tab> ORDINAL_TO_TAB_MAP = Arrays.stream(values())
		.collect(toMap(t -> String.valueOf(t.ordinal()), Function.identity()));

	@JsonCreator
	public static Tab forValue(String value) {
		return ORDINAL_TO_TAB_MAP.get(value);
	}
}
