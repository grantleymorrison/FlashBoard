package io.flashboard.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.dao.QuizDao;
import io.flashboard.dao.QuizDaoImpl;

@Path("/quiz")
public class QuizWS {
	// GET request for quiz by ID
	@GET
	@Path("/{quizId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Quiz get(@PathParam("quizId") int quizId) {
		QuizDao qd = new QuizDaoImpl();
		Quiz quiz = qd.getQuizById(quizId);
		if(quiz == null) {
			return null;
		}
		return quiz;
	}
	
	// GET request to grab all quizzes
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Quiz> all() {
		QuizDao qd = new QuizDaoImpl();
		List<Quiz> quizzes = qd.getAllQuizzes();
		return quizzes;
	}
}
