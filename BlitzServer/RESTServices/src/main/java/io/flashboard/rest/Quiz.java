package io.flashboard.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.jsonbeans.QuizData;
import io.flashboard.service.QuizService;

@Path("/quiz_insert")
public class Quiz {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response submitQuiz(QuizData quiz) {
		
		if(QuizService.insert(quiz)) {
			return Response.status(200).build();
		}
		
		return Response.status(400).build();
	}
}
