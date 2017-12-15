package io.flashboard.beans;

import java.util.List;

public abstract class TestQuestion {
	
	private int questionId;
	private String questionText;
	private List<String> answers;
	private int pointsPossible; 
	private List<CommentFlag> flags;
	private List<CommentMessage> comments;
	
	
	
	
	public TestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.answers = answers;
		this.pointsPossible = pointsPossible;
	}
	public TestQuestion(String questionText, List<String> answers, int pointsPossible, List<CommentFlag> flags,
			List<CommentMessage> comments) {
		super();
		this.questionText = questionText;
		this.answers = answers;
		this.pointsPossible = pointsPossible;
		this.flags = flags;
		this.comments = comments;
	}
	public TestQuestion(int questionId, String questionText, List<String> answers, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.answers = answers;
		this.pointsPossible = pointsPossible;
		this.flags = flags;
		this.comments = comments;
	}
	
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public int getPointsPossible() {
		return pointsPossible;
	}
	public void setPointsPossible(int pointsPossible) {
		this.pointsPossible = pointsPossible;
	}
	public List<CommentFlag> getFlags() {
		return flags;
	}
	public void setFlags(List<CommentFlag> flags) {
		this.flags = flags;
	}
	public List<CommentMessage> getComments() {
		return comments;
	}
	public void setComments(List<CommentMessage> comments) {
		this.comments = comments;
	}
	
	

}
