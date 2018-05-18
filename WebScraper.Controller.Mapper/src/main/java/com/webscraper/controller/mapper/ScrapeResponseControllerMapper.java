package com.webscraper.controller.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.controller.model.ScrapeResponseControllerModel;
import com.webscraper.domain.ScrapeResponse;

@Component
public interface ScrapeResponseControllerMapper {

	ScrapeResponseControllerModel map(ScrapeResponse scrapeResponse);
}
