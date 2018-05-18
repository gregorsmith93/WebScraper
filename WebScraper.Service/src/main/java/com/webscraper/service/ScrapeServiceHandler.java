package com.webscraper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webscraper.domain.ScrapeRequest;
import com.webscraper.domain.ScrapeResponse;
import com.webscraper.integration.ScrapeRequestService;

@Service
public class ScrapeServiceHandler implements ScrapeService {

	private final ScrapeRequestService scrapeRequestService;

	@Autowired
	public ScrapeServiceHandler(final ScrapeRequestService scrapeRequestService) {
		this.scrapeRequestService = scrapeRequestService;
	}

	@Override
	public ScrapeResponse performScrapeRequest(final ScrapeRequest scrapeRequest) {

		return scrapeRequestService.performScrapeRequest(scrapeRequest);
	}

}
