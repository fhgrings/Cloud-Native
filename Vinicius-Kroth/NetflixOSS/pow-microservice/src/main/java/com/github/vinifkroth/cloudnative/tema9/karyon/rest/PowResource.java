package com.github.vinifkroth.cloudnative.tema9.karyon.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

@Singleton
@Path("/math")
public class PowResource {

	private static final Logger logger = LoggerFactory.getLogger(PowResource.class);
	
	private PowService service;

	@Inject
	public PowResource(PowService service) {
		this.service = service;
	}
	
	@GET
	@Path("pow/{firstElem}/{secondElemen}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response set(@PathParam("firstElem") Double firstElement,@PathParam("secondElemen") Double secondElement) {
		try {
			return Response.ok( service.sum(firstElement, secondElement) + "" ).build();
		} catch (Exception e) {
			logger.error("Error creating json response.", e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
