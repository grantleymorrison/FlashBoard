package io.flashboard.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.flashboard.beans.studyguide.CommentSG;

@Path("/comment")
public class Comment {

	@GET
	@Path("/guide/{guideId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CommentSG> getGuideComments(@PathParam("guideId") int id){
		
	}
}
