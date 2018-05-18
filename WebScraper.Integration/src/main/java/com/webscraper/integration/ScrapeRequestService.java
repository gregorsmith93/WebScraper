package com.webscraper.integration;

import org.springframework.stereotype.Component;

import com.webscraper.domain.ScrapeRequest;
import com.webscraper.domain.ScrapeResponse;

@Component
public interface ScrapeRequestService {

	ScrapeResponse performScrapeRequest(ScrapeRequest scrapeRequest);
}
