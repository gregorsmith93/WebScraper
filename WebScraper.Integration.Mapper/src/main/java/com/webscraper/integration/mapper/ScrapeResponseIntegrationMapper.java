package com.webscraper.integration.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.domain.ScrapeResponse;
import com.webscraper.integration.model.ScrapeResponseIntegrationModel;

@Component
public interface ScrapeResponseIntegrationMapper {

	ScrapeResponse map(ScrapeResponseIntegrationModel<?> integrationScrapeResponse);
}
