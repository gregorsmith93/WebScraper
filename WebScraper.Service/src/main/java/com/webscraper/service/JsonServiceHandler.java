package com.webscraper.service;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonServiceHandler implements JsonService {

	@Override
	public String prettyPrint(final Object object) {

		String jsonString = StringUtils.EMPTY;

		try {
			jsonString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (final JsonMappingException e) {

		} catch (final JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonString;
	}

}
