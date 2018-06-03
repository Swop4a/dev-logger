package com.devlogger.post.services.impl;

import com.devlogger.post.services.TextService;
import org.springframework.stereotype.Service;

/**
 * @author swop4a
 * @since 30/05/2018 17:21
 */
@Service
public class TextServiceImpl implements TextService {

	private static final Integer LIMIT = 1500;
	private static final String NEW_PARAGRAPH = "\n\n";
	private static final String DOT = ".";

	@Override
	public String toPreview(String text) {
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
