package io.flashboard.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrueFalseTestQuestion extends TestQuestion {
	
	//TODO Redundant? Have TestQuestion
	@Column
	private boolean correctAnswer;

	public TrueFalseTestQuestion() {
		super();
		
	}

	public TrueFalseTestQuestion(boolean correctAnswer) {
		super();
		this.correctAnswer = correctAnswer;
	}

	public TrueFalseTestQuestion(int questionId, String topic, String questionText, String questionAnswer, String questionOption1, int pointsPossible, boolean correctAnswer) {
		super(questionId, topic, questionText, questionAnswer, questionOption1, pointsPossible);
		this.correctAnswer = correctAnswer;
	}

	public TrueFalseTestQuestion(String topic, String questionText, String questionAnswer, String questionOption1, String explanation, int pointsPossible, List<CommentFlag> flags,
			List<Message> comments, boolean correctAnswer) {
		super(topic, questionText, questionAnswer, questionOption1, explanation, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		
	}
	
	

}
