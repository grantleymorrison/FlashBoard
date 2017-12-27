package io.flashboard.factories;



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
	public QuizQuestion generateTrueFalseQuestion(String questionText, boolean answer, String explanation) {
		QuizQuestion ques = generateTrueFalseQuestion(questionText,answer);
		ques.setExplanation(explanation);

		return ques; 
	}
	public QuizQuestion generateTrueFalseQuestion(String questionText, boolean answer, String explanation, String creatorId) {
		QuizQuestion ques = generateTrueFalseQuestion(questionText,answer, explanation);
		ques.setCreatedBy(creatorId);

		return ques; 
	}
	
	public QuizQuestion generateMultipleChoiceQuestion(String questionText, String answer, String[] options) {
		QuizQuestion ques = new QuizQuestion();
		ques.setQuestionText(questionText); 
		ques.setAnswer(answer);
		ques.setOptions(options);	
		
		return ques; 
	}
	public QuizQuestion generateMultipleChoiceQuestion(String questionText, String answer, String[] options, String explanation) {
		QuizQuestion ques = generateMultipleChoiceQuestion(questionText, answer, options);
		ques.setExplanation(explanation);
		
		return ques; 
	}	
	public QuizQuestion generateMultipleChoiceQuestion(String questionText, String answer, String[] options, String explanation, String creatorId) {
		QuizQuestion ques = generateMultipleChoiceQuestion(questionText, answer, options, explanation);
		ques.setCreatedBy(creatorId);		
		
		return ques; 
	}
	
	
	
	
	

}
