package com.webscraper.domain;

public enum ScrapeResponseStatus {

	SUCCESS("success"), FAIL("fail"), UNKNOWN("unknown");

	private final String value;

	private ScrapeResponseStatus(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ScrapeResponseStatus getEnumFromValue(final String value) {

		ScrapeResponseStatus scrapeResponseStatus = ScrapeResponseStatus.UNKNOWN;

		for (final ScrapeResponseStatus status : ScrapeResponseStatus.values()) {
			if (status.getValue().equals(value)) {
				scrapeResponseStatus = status;
			}
		}
		return scrapeResponseStatus;
	}
}
