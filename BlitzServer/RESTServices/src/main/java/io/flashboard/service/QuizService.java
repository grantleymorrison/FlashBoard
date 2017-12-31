package io.flashboard.service;

import java.util.ArrayList;
import java.util.List;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;
import io.flashboard.dao.QuizDaoImpl;
import io.flashboard.jsonbeans.QuestionData;
import io.flashboard.jsonbeans.QuizData;

public class QuizService {
	
	public static boolean insert(QuizData quiz) {
		Quiz quizBean = translateToQuizBean(quiz);
		QuizDaoImpl qdi = new QuizDaoImpl();
		
		if(qdi.insertQuiz(quizBean) != null) {
			return true;
		}
		
		return false;
	}
	
	
	private static Quiz translateToQuizBean(QuizData quiz) {
		String creator = quiz.getCreator();
		String quizTitle = quiz.getQuizTitle();
		String quizTopic = quiz.getQuizTopic();
		List<QuestionData> qd = quiz.getQuestions();
		List<QuizQuestion> q = new ArrayList<>();
		ArrayList<String> options = new ArrayList<>();
		QuizQuestion qq = null;
		
		for(QuestionData qds: qd) {
			options.add(qds.getCanswer());
			options.add(qds.getWanswer1());
			options.add(qds.getWanswer2());
			options.add(qds.getWanswer3());
			qq = new QuizQuestion(qds.getQuestion(), options, qds.getCanswer(), 1);
			q.add(qq);
		}
		
		
		return new Quiz(quizTitle, quizTopic, q, creator, qd.size());
	}
}
