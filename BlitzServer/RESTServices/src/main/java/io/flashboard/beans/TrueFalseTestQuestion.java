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

	public TrueFalseTestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, 
			int pointsPossible, List<CommentFlag> flags, List<Message> comments, boolean correctAnswer) {
		super(questionId, questionText, questionAnswer, questionOption1, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
	}

	public TrueFalseTestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, int pointsPossible, boolean correctAnswer) {
		super(questionId, questionText, questionAnswer, questionOption1, pointsPossible);
		this.correctAnswer = correctAnswer;
	}

	public TrueFalseTestQuestion(String questionText, String questionAnswer, String questionOption1, int pointsPossible, List<CommentFlag> flags,
			List<Message> comments, boolean correctAnswer) {
		super(questionText, questionAnswer, questionOption1, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}
	
	

}
