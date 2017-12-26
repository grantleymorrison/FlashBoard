package io.flashboard.factories;

import java.util.ArrayList;

import io.flashboard.beans.TestQuestion;

public class QuestionFactory {
	
	public static QuestionFactory qf;
	
	public QuestionFactory getQuestionFactory() {
		if(qf == null)
			qf = new QuestionFactory(); 
		return qf; 
	}
	
	private QuestionFactory() {
		
	}
	
	public TestQuestion generateTrueFalseQuestion(String questionText, boolean answer) {
		TestQuestion tq = new TestQuestion(); 
		tq.setQuestionText(questionText);
		tq.setAnswer(answer ? "True" : "False");
		String[] options = {"True","False"};
		tq.setOptions(options);
		ArrayList<String> str = new ArrayList<>(); 
		
		
		return null; 
	}
	
	

}
