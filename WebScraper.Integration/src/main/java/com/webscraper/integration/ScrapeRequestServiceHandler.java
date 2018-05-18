package com.webscraper.integration;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webscraper.domain.ScrapeRequest;
import com.webscraper.domain.ScrapeResponse;
import com.webscraper.integration.mapper.ScrapeRequestIntegrationMapper;
import com.webscraper.integration.mapper.ScrapeResponseIntegrationMapper;
import com.webscraper.integration.model.ScrapeRequestIntegrationModel;
import com.webscraper.integration.model.ScrapeResponseIntegrationModel;
import com.webscraper.integration.model.ScrapeResponseStatus;

@Component
public class ScrapeRequestServiceHandler implements ScrapeRequestService {

	private final ScrapeRequestIntegrationMapper scrapeRequestIntegrationMapper;

	private final ScrapeResponseIntegrationMapper scrapeResponseIntegrationMapper;

	private final ScrapeIntegrationService scrapeIntegrationService;

	@Autowired
	public ScrapeRequestServiceHandler(final ScrapeIntegrationService scrapeIntegrationService,
			final ScrapeRequestIntegrationMapper scrapeRequestIntegrationMapper,
			final ScrapeResponseIntegrationMapper scrapeResponseIntegrationMapper) {
		this.scrapeIntegrationService = scrapeIntegrationService;
		this.scrapeRequestIntegrationMapper = scrapeRequestIntegrationMapper;
		this.scrapeResponseIntegrationMapper = scrapeResponseIntegrationMapper;
	}

	@Override
	public ScrapeResponse performScrapeRequest(final ScrapeRequest scrapeRequest) {

		final ScrapeRequestIntegrationModel scrapeRequestIntegrationModel = scrapeRequestIntegrationMapper
				.map(scrapeRequest);

		ScrapeResponseIntegrationModel<?> scrapeResponse;
		try {
			scrapeResponse = scrapeIntegrationService
					.getPageElements(scrapeRequestIntegrationModel.getUrl());
		} catch (final ServletException exception) {
			scrapeResponse = new ScrapeResponseIntegrationModel<String>(null, ScrapeResponseStatus.FAIL, exception);
		}

		return scrapeResponseIntegrationMapper.map(scrapeResponse);
	}

}
