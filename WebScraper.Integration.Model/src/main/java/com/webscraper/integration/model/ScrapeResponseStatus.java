package com.webscraper.integration.model;

public enum ScrapeResponseStatus {

	SUCCESS("success"), FAIL("fail");

	private final String value;

	private ScrapeResponseStatus(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
