package io.flashboard.factories;

public class QuizFactory {
	
	private static QuizFactory qf; 
	
	public static QuizFactory getQuizFactory() {
		if(qf == null)
			qf = new QuizFactory(); 
		return qf; 
	}
	
	private QuizFactory() {
		
	}
	
	
	
	
}
