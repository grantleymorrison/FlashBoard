package io.flashboard.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.beans.studyguide.StudyGuide;
import io.flashboard.dao.StudyGuideDao;
import io.flashboard.dao.StudyGuideDaoImpl;
import io.flashboard.jsonbeans.StudyGuideData;
import io.flashboard.service.StudyGuideService;

@Path("/guide")
public class StudyGuideRest {
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
	@Path("/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudyGuide get(@PathParam("postId") int postId) {
		StudyGuideDao sgd = new StudyGuideDaoImpl();
		StudyGuide guide = sgd.getStudyGuide(postId);
		if(guide == null) {
			return null;
		}
		return guide;
	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudyGuide> all() {
		StudyGuideDao sgd = new StudyGuideDaoImpl();
		List<StudyGuide> guideList = sgd.getAllStudyGuides();
		if(guideList == null) {
			return null;
		}
		return guideList;
		
	}
	
}
