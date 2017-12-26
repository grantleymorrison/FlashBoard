package io.flashboard.factories;

import java.util.ArrayList;

import io.flashboard.beans.quiz.QuizQuestion;

public class QuestionFactory {
	
	public static QuestionFactory qf;
	
	public QuestionFactory getQuestionFactory() {
		if(qf == null)
			qf = new QuestionFactory(); 
		return qf; 
	}
	
	private QuestionFactory() {
		
	}
	
	public QuizQuestion generateTrueFalseQuestion(String questionText, boolean answer) {
		QuizQuestion ques = new QuizQuestion(); 
		
		ques.setQuestionText(questionText);
		ques.setAnswer(answer ? "True" : "False");
		String[] options = {"True","False"};
		ques.setOptions(options);

		return ques; 
	}
	
	
	
	

}
