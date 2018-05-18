package com.webscraper.integration.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.domain.ScrapeResponse;
import com.webscraper.domain.ScrapeResponseStatus;
import com.webscraper.integration.model.ScrapeResponseIntegrationModel;

@Component
public class ScrapeResponseIntegrationMapperHandler implements ScrapeResponseIntegrationMapper {

	@Override
	public ScrapeResponse map(final ScrapeResponseIntegrationModel<?> integrationScrapeResponse) {

		final ScrapeResponse scrapeResponse = new ScrapeResponse();
		scrapeResponse.setStatus(ScrapeResponseStatus
				.getEnumFromValue(integrationScrapeResponse.getStatus().getValue()));

		String content = null;

		if (null != integrationScrapeResponse.getScrapeResponse()) {
			content = integrationScrapeResponse.getScrapeResponse().toString();
		}

		scrapeResponse.setContent(content);
		scrapeResponse.setError(integrationScrapeResponse.getError());

		return scrapeResponse;
	}
}
