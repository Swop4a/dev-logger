package com.devlogger.post.api.converters;

import java.sql.Date;
import org.springframework.core.convert.converter.Converter;

/**
 * @author swop4a
 * @since 31/05/2018 21:48
 */
public class UtilDateToSQLDateConverter implements Converter<java.util.Date, Date> {


	@Override
	public Date convert(java.util.Date source) {
		if (source != null) {
			return new Date(source.getTime());
		}
		return null;
	}
}
