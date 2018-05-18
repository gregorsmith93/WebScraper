package com.webscraper.domain;

public class ScrapeResponse {

	private String content;

	private ScrapeResponseStatus status;

	private Exception error;

	public ScrapeResponse() {

	}

	public ScrapeResponse(final String content, final ScrapeResponseStatus status, final Exception error) {
		this.setContent(content);
		this.setStatus(status);
		this.setError(error);
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public ScrapeResponseStatus getStatus() {
		return status;
	}

	public void setStatus(final ScrapeResponseStatus status) {
		this.status = status;
	}

	public Exception getError() {
		return error;
	}

	public void setError(Exception error) {
		this.error = error;
	}
}
