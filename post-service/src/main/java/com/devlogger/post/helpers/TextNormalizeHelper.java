package com.devlogger.post.helpers;

/**
 * @author swop4a
 * @since 30/05/2018 17:21
 */

public class TextNormalizeHelper {

	private static final Integer LIMIT = 1500;
	private static final String NEW_PARAGRAPH = "\n\n";
	private static final String DOT = ".";

	public static String normalize(String text) {
		StringBuilder content = new StringBuilder(text);
		content = cropContent(content);
		content = removeSpecialTags(content);

		return removeImagesFromContent(content).toString();
	}

	private static StringBuilder removeSpecialTags(StringBuilder content) {
		return content;
	}

	private static StringBuilder removeImagesFromContent(StringBuilder content) {
		return content;
	}

	private static StringBuilder cropContent(StringBuilder content) {
		content = content.delete(Math.min(content.length(), LIMIT), content.length());

		int indexOfNewParagraph = content.lastIndexOf(NEW_PARAGRAPH);
		int indexOfLastDot = content.lastIndexOf(DOT);

		if (indexOfNewParagraph > indexOfLastDot) {
			return content.delete(Math.max(0, indexOfNewParagraph), content.length());
		} else {
			return content.delete(Math.max(0, indexOfLastDot), content.length());
		}
	}
}
