package com.webscraper.integration.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.domain.ScrapeRequest;
import com.webscraper.integration.model.ScrapeRequestIntegrationModel;

@Component
public class ScrapeRequestIntegrationMapperHandler implements ScrapeRequestIntegrationMapper {

	@Override
	public ScrapeRequestIntegrationModel map(final ScrapeRequest scrapeRequest) {

		final ScrapeRequestIntegrationModel scrapeRequestIntegrationModel = new ScrapeRequestIntegrationModel();
		scrapeRequestIntegrationModel.setUrl(scrapeRequest.getUrl());

		return scrapeRequestIntegrationModel;
	}
}
