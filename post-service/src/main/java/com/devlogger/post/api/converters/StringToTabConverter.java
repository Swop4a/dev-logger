package com.devlogger.post.api.converters;

import com.devlogger.post.model.Tab;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author swop4a
 * @since 20/05/2018 20:01
 */
@Component
public class StringToTabConverter implements Converter<String, Tab> {

	@Override
	public Tab convert(String s) {
		return Tab.forValue(s);
	}
}
