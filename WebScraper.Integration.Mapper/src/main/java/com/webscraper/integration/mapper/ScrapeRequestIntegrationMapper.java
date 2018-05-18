package com.webscraper.integration.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.domain.ScrapeRequest;
import com.webscraper.integration.model.ScrapeRequestIntegrationModel;

@Component
public interface ScrapeRequestIntegrationMapper {

	ScrapeRequestIntegrationModel map(ScrapeRequest scrapeRequest);
}
