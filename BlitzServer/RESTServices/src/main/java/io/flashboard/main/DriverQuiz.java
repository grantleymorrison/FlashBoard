package io.flashboard.main;

import java.util.HashSet;
import java.util.Set;

import io.flashboard.beans.quiz.QuizQuestion;
import io.flashboard.dao.QuizDaoImpl;
import io.flashboard.dao.UserDaoImpl;

public class DriverQuiz {
	
	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		
		udi.createNewUser("James", "Baxter", "gamesbookstore", "real@email.com", "no");
		
		QuizDaoImpl qdi = new QuizDaoImpl();
		
		HashSet<String> options = new HashSet<String>();
		options.add("Finalize"); options.add("Finally"); options.add("Final");   
		QuizQuestion question = new QuizQuestion("What do you call to signify garbage collection?", "Java", options, "Finalize");
		Set<QuizQuestion> questions = new HashSet<QuizQuestion>();
		
		qdi.createQuiz("Garbage Collection", "Java", "Review keywords!", questions, udi.getUserByUsername("gamesbookstore").getUsername(), 100);
		qdi.addQuestionToQuizByQuizId(50, question);
		qdi.addCommentByQuizId(50, "gamesbookstore", "Excellent exam!!");
		
	}
	
}
