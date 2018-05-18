package com.webscraper.integration;

import java.io.IOException;

import javax.servlet.ServletException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.webscraper.integration.model.ScrapeResponseIntegrationModel;
import com.webscraper.integration.model.ScrapeResponseStatus;

@Component
public class JSoupScraper implements ScrapeIntegrationService {

	@Override
	public ScrapeResponseIntegrationModel<Document> getPageElements(final String url) throws ServletException {

		Document content = null;
		ScrapeResponseStatus scrapeResponseStatus = ScrapeResponseStatus.SUCCESS;
		Exception error = null;
		try {
			final Document document = Jsoup.connect(url).get();
			document.select("script, style").remove();
			content = document;
		} catch (final IllegalArgumentException | IOException e) {
			scrapeResponseStatus = ScrapeResponseStatus.FAIL;
			error = e;
		}

		return new ScrapeResponseIntegrationModel<Document>(content, scrapeResponseStatus, error);
	}
}
