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

import io.flashboard.beans.studyguide.CommentSG;
import io.flashboard.dao.StudyGuideDaoImpl;
import io.flashboard.jsonbeans.CommentData;
import io.flashboard.service.CommentService;

@Path("/comment")
public class Comment {

	@GET
	@Path("/guide/{guideId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CommentSG> getGuideComments(@PathParam("guideId") int id){
		StudyGuideDaoImpl sgdi = new StudyGuideDaoImpl();
		List<CommentSG> comments = sgdi.getStudyGuideComments(id);
		
		return comments;
	}
	
	@POST
	@Path("/guide/add/{guideId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGuideComment(@PathParam("guideId") int id, CommentData cd) {
		System.out.println("Helllo");
		if(CommentService.addGuideComment(cd, id)) {
			return Response.status(200).build();
		}
		
		return Response.status(200).build();
	}
}
