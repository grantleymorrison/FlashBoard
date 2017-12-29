package io.flashboard.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.dao.StudyGuideDao;
import io.flashboard.dao.StudyGuideDaoImpl;

@Path("/guide")
public class StudyGuide {
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create() {
		StudyGuideDao sd = new StudyGuideDaoImpl();
		
		
		int some = 2;
		if (some == 2) {
			return Response.status(200).build();
		}
		return Response.status(400).build();
	}
}
