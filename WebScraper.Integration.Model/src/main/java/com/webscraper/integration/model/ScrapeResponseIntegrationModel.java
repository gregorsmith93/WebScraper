package com.webscraper.integration.model;

public class ScrapeResponseIntegrationModel<T> {

	private final T scrapeResponse;

	private final ScrapeResponseStatus status;

	private final Exception error;

	public ScrapeResponseIntegrationModel(final T response, final ScrapeResponseStatus scrapeResponseStatus,
			final Exception error) {
		this.scrapeResponse = response;
		this.status = scrapeResponseStatus;
		this.error = error;
	}

	public T getScrapeResponse() {
		return scrapeResponse;
	}

	public ScrapeResponseStatus getStatus() {
		return status;
	}

	public Exception getError() {
		return error;
	}
}
