package com.webscraper.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.webscraper.controller.mapper.ScrapeRequestControllerMapper;
import com.webscraper.controller.mapper.ScrapeResponseControllerMapper;
import com.webscraper.controller.model.ErrorContainer;
import com.webscraper.controller.model.ScrapeRequestControllerModel;
import com.webscraper.domain.ScrapeRequest;
import com.webscraper.domain.ScrapeResponse;
import com.webscraper.domain.ScrapeResponseStatus;
import com.webscraper.service.JsonService;
import com.webscraper.service.ScrapeService;

@Path(ControllerConstants.SCRAPE_URL)
@Controller
public class ScrapeController {

	private final ScrapeRequestControllerMapper scrapeRequestControllerMapper;

	private final ScrapeService scrapeService;

	private final JsonService jsonService;

	private final ScrapeResponseControllerMapper scrapeResponseControllerMapper;

	@Autowired
	public ScrapeController(final ScrapeService scrapeService,
			final ScrapeRequestControllerMapper scrapeRequestControllerMapper, final JsonService jsonService,
			final ScrapeResponseControllerMapper scrapeResponseControllerMapper) {
		this.scrapeService = scrapeService;
		this.scrapeRequestControllerMapper = scrapeRequestControllerMapper;
		this.jsonService = jsonService;
		this.scrapeResponseControllerMapper = scrapeResponseControllerMapper;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHome(@QueryParam(value = "url") final String url) {

		final ScrapeRequestControllerModel scrapeRequestControllerModel = new ScrapeRequestControllerModel();
		scrapeRequestControllerModel.setUrl(url);

		final ScrapeRequest scrapeRequest = scrapeRequestControllerMapper.map(scrapeRequestControllerModel);

		final ScrapeResponse scrapeResponse = scrapeService.performScrapeRequest(scrapeRequest);

		String response = StringUtils.EMPTY;
		if (scrapeResponse.getStatus().equals(ScrapeResponseStatus.SUCCESS)) {
			response = jsonService.prettyPrint(scrapeResponseControllerMapper.map(scrapeResponse));
		} else {
			final ErrorContainer errorContainer = new ErrorContainer();
			errorContainer.setErrorCode(Status.BAD_REQUEST.getStatusCode());
			errorContainer.setMessage(scrapeResponse.getError().getMessage());

			response = jsonService.prettyPrint(errorContainer);
		}

		return Response.ok().entity(response).build();
	}
}
