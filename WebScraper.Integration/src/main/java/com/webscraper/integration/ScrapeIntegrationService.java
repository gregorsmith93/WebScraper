package com.webscraper.integration;

import javax.servlet.ServletException;

import org.springframework.stereotype.Component;

import com.webscraper.integration.model.ScrapeResponseIntegrationModel;

@Component
public interface ScrapeIntegrationService {

	ScrapeResponseIntegrationModel<?> getPageElements(String url) throws ServletException;
}
