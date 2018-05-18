package com.webscraper.controller.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.controller.model.ScrapeRequestControllerModel;
import com.webscraper.domain.ScrapeRequest;

@Component
public interface ScrapeRequestControllerMapper {

	ScrapeRequest map(ScrapeRequestControllerModel scrapeRequest);
}
