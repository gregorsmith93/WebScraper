package com.webscraper.service;

import org.springframework.stereotype.Service;

import com.webscraper.domain.ScrapeRequest;
import com.webscraper.domain.ScrapeResponse;

@Service
public interface ScrapeService {

	ScrapeResponse performScrapeRequest(ScrapeRequest scrapeRequest);
}
