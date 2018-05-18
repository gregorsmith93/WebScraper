package com.webscraper.controller.mapper;

import org.springframework.stereotype.Component;

import com.webscraper.controller.model.ScrapeResponseControllerModel;
import com.webscraper.domain.ScrapeResponse;

@Component
public class ScrapeResponseControllerMapperHandler implements ScrapeResponseControllerMapper {

	@Override
	public ScrapeResponseControllerModel map(final ScrapeResponse scrapeResponse) {

		final ScrapeResponseControllerModel scrapeResponseControllerModel = new ScrapeResponseControllerModel();
		scrapeResponseControllerModel.setContent(scrapeResponse.getContent());

		return scrapeResponseControllerModel;
	}
}
