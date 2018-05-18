package com.webscraper.controller.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.controller.model.ScrapeRequestControllerModel;
import com.webscraper.domain.ScrapeRequest;

@Component
public class ScrapeRequestControllerMapperHandler implements ScrapeRequestControllerMapper {

	@Override
	public ScrapeRequest map(final ScrapeRequestControllerModel scrapeRequestControllerModel) {

		final ScrapeRequest scrapeRequest = new ScrapeRequest();
		scrapeRequest.setUrl(scrapeRequestControllerModel.getUrl());

		return scrapeRequest;
	}
}
