package io.flashboard.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.jsonbeans.StudyGuideData;
import io.flashboard.service.StudyGuideService;

@Path("/guide")
public class StudyGuide {
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(StudyGuideData sgd) {
		if(StudyGuideService.validate(sgd)) {
			return Response.status(200).build();
		}
		return Response.status(400).build();
	}
	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get() {
		
		int some = 2;
		if (some == 2) {
			return Response.status(200).build();
		}
		return Response.status(400).build();
	}
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response all() {
		
		int some = 2;
		if (some == 2) {
			return Response.status(200).build();
		}
		return Response.status(400).build();
	}
	
}
