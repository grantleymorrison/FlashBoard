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
import io.flashboard.dao.QuizDaoImpl;
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
		
		return Response.status(400).build();
	}
	
	@GET
	@Path("/quiz/{quizId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<io.flashboard.beans.quiz.Comment> getQuizComments(@PathParam("quizId") int id){
		QuizDaoImpl qdi = new QuizDaoImpl();
		List<io.flashboard.beans.quiz.Comment> comments = qdi.getQuizComments(id);
		
		return comments;
	}
	
	@POST
	@Path("/quiz/add/{quizId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addQuizComment(@PathParam("quizId") int id, CommentData cd) {
		if(CommentService.addQuizComment(cd, id)) {
			return Response.status(200).build();
		}
		return Response.status(400).build();
	}
}
