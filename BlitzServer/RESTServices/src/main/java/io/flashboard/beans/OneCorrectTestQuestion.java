package io.flashboard.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OneCorrectTestQuestion extends TestQuestion{
	
	
	//TODO Redundant? Have TestQuestion
	@Column
	private String correctAnswer;
	

	public OneCorrectTestQuestion(String correctAnswer) {
		super();
		this.correctAnswer = correctAnswer;
	}

	public OneCorrectTestQuestion() {
		super();
		
	}

	public OneCorrectTestQuestion(int questionId, String topic, String questionText, String questionAnswer, 
			String questionOption1, String questionOption2, 
			String questionOption3, int pointsPossible,
			List<CommentFlag> flags, List<Message> comments, String correctAnswer) {
		super(questionId, topic, questionText, questionAnswer, questionOption1, questionOption2, 
				questionOption3, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		
	}

	public OneCorrectTestQuestion(int questionId, String topic, String questionText, String questionAnswer, String questionOption1,
			String questionOption2, String questionOption3, String explanation, int pointsPossible, String correctAnswer) {
		super(questionId, topic,  questionText, questionAnswer, questionOption1, questionOption2, 
				questionOption3, explanation,  pointsPossible);
		this.correctAnswer = correctAnswer;
		
	}

	public OneCorrectTestQuestion(String topic, String questionText, String questionAnswer, String questionOption1,
			String questionOption2, String questionOption3, String explanation, int pointsPossible, String correctAnswer) {
		super(topic, questionText, questionAnswer, questionOption1, questionOption2, 
				questionOption3, explanation, pointsPossible);
		this.correctAnswer = correctAnswer;
	
	}
	
	

}
