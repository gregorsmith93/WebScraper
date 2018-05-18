package com.webscraper.controller.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.webscraper.controller.model.ErrorContainer;
import com.webscraper.service.JsonService;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

	private final JsonService jsonService;

	@Autowired
	public IllegalArgumentExceptionMapper(final JsonService jsonService) {
		this.jsonService = jsonService;
	}

	@Override
	public Response toResponse(final IllegalArgumentException exception) {

		final ErrorContainer errorContainer = new ErrorContainer();
		errorContainer.setErrorCode(Status.BAD_REQUEST.getStatusCode());
		errorContainer.setMessage(exception.getMessage());

		final String json = jsonService.prettyPrint(errorContainer);

		return Response.status(Status.BAD_REQUEST).entity(json).build();
	}
}
