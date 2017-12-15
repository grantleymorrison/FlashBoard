package io.flashboard.beans;

import java.util.List;

public class OneCorrectTestQuestion extends TestQuestion{
	
	private String correctAnswer;
	

	public OneCorrectTestQuestion(String correctAnswer) {
		super();
		this.correctAnswer = correctAnswer;
	}

	public OneCorrectTestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OneCorrectTestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments, String correctAnswer) {
		super(questionId, questionText, answers, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public OneCorrectTestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible, String correctAnswer) {
		super(questionId, questionText, answers, pointsPossible);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public OneCorrectTestQuestion(String questionText, List<String> answers, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments, String correctAnswer) {
		super(questionText, answers, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}
	
	

}
