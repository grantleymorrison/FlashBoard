package io.flashboard.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MultiCorrectTestQuestion extends TestQuestion{
	
	@Column
	private Set<String> correctAnswer;

	public MultiCorrectTestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultiCorrectTestQuestion(Set<String> correctAnswer) {
		super();
		this.correctAnswer = correctAnswer;
	}

	public MultiCorrectTestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments, Set<String> correctAnswer) {
		super(questionId, questionText, answers, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public MultiCorrectTestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible, Set<String> correctAnswer) {
		super(questionId, questionText, answers, pointsPossible);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public MultiCorrectTestQuestion(String questionText, List<String> answers, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments, Set<String> correctAnswer) {
		super(questionText, answers, pointsPossible, flags, comments);
		this.correctAnswer = correctAnswer;
		// TODO Auto-generated constructor stub
	}

	public Set<String> getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Set<String> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	

}
