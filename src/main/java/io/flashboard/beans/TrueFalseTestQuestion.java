package io.flashboard.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrueFalseTestQuestion extends TestQuestion {
	
	@Column
	private boolean correctAnswer;

	public TrueFalseTestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrueFalseTestQuestion(boolean correctAnswer) {
		super();
		this.correctAnswer = correctAnswer;
	}

	public TrueFalseTestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments, boolean correctAnswer) {
		super(questionId, questionText, answers, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public TrueFalseTestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible, boolean correctAnswer) {
		super(questionId, questionText, answers, pointsPossible);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public TrueFalseTestQuestion(String questionText, List<String> answers, int pointsPossible, List<CommentFlag> flags,
			List<CommentMessage> comments, boolean correctAnswer) {
		super(questionText, answers, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	

}
