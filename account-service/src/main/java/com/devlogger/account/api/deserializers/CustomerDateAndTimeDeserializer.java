package com.devlogger.account.api.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author swop4a
 * @since 15/07/2018 12:20
 */
public class CustomerDateAndTimeDeserializer extends JsonDeserializer<Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
		throws IOException {

		String str = paramJsonParser.getText().trim();
		try {
			return dateFormat.parse(str);
		} catch (ParseException e) {
		}
		return paramDeserializationContext.parseDate(str);
	}
}
