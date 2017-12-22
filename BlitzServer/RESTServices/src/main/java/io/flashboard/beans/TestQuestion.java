package io.flashboard.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class TestQuestion {
	
	@Id
	@Column(name = "QUESTION_ID")
	@SequenceGenerator(sequenceName = "QUESTION_SEQ", name = "QUESTION_SEQ")	
	@GeneratedValue(generator = "QUESTION_SEQ", strategy = GenerationType.SEQUENCE)		
	private int questionId;
	
	@Column(name = "QUESTION_TEXT")
	private String questionText;
	
	@Column(name = "QUESTION_ANSWER")
	private String questionAnswer;
	
	@Column(name = "QUESTION_OPTION_1") 
	private String questionOption1;
	
	@Column(name = "QUESTION_OPTION_2") 
	private String questionOption2;
	
	@Column(name = "QUESTION_OPTION_3")
	private String questionOption3;
	
	@Column(name = "POINTS_POSSIBLE")
	private int pointsPossible; 
	
	@Column
	private String explanation; 
	
	@OneToMany(fetch=FetchType.EAGER, orphanRemoval = true)
	@Column(name = "FLAGS")
	private List<CommentFlag> flags;
	
	@OneToMany(fetch=FetchType.EAGER, orphanRemoval = true)
	@Column(name = "COMMENTS")
	private List<Message> comments;
	
	@Column 
	private String createdBy; 
	
	@Column 
	private LocalDateTime createdOn; 
	
	
	
	
	public TestQuestion() {
		super();
		
	}
	public TestQuestion(String questionText , String questionAnswer ,
			String questionOption1 , int pointsPossible , String explanation ) {
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.pointsPossible = pointsPossible;
		this.explanation = explanation;
		
		this.comments = new ArrayList<Message>(); 
		this.flags = new ArrayList<CommentFlag>(); 
		this.questionOption2 = ""; 
		this.questionOption3 = ""; 
		this.createdBy = "N/A"; 
		this.createdOn = LocalDateTime.now();
		
	}
	public TestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, String questionOption2, 
			String questionOption3, String explanation, int pointsPossible) {
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.questionOption2 = questionOption2;
		this.questionOption3 = questionOption3;
		this.pointsPossible = pointsPossible;
		this.explanation = explanation;
		

		this.comments = new ArrayList<Message>(); 
		this.flags = new ArrayList<CommentFlag>(); 
		this.createdBy = "N/A"; 
		this.createdOn = LocalDateTime.now();
	}
	public TestQuestion(String questionText, String questionAnswer, String questionOption1, String questionOption2, 
			String questionOption3, String explanation, int pointsPossible) {
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.questionOption2 = questionOption2;
		this.questionOption3 = questionOption3;
		this.pointsPossible = pointsPossible;
		this.explanation = explanation;
		
		this.flags = new ArrayList<CommentFlag>();
		this.comments = new ArrayList<Message>();
		this.createdBy = "N/A"; 
		this.createdOn = LocalDateTime.now();
	}
	
	public TestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, int pointsPossible) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.pointsPossible = pointsPossible;

		this.questionOption2 = ""; 
		this.questionOption3 = ""; 
		this.explanation = ""; 
		this.flags = new ArrayList<CommentFlag>();
		this.comments = new ArrayList<Message>();
		this.createdBy = "N/A"; 
		this.createdOn = LocalDateTime.now();
	}
	
	public TestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, String questionOption2, 
			String questionOption3, int pointsPossible,
			List<CommentFlag> flags, List<Message> comments) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.questionOption2 = questionOption2;
		this.questionOption3 = questionOption3;
		this.pointsPossible = pointsPossible;
		
		this.flags = flags;
		this.comments = comments;
		this.createdBy = "N/A"; 
		this.createdOn = LocalDateTime.now();
	}
	public TestQuestion(String questionText, String questionAnswer, String questionOption1, String explanation, int pointsPossible,
			List<CommentFlag> flags, List<Message> comments) {
		super();
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.pointsPossible = pointsPossible;
		this.explanation = explanation;
		this.flags = flags;
		this.comments = comments;
		
		this.flags = new ArrayList<CommentFlag>();
		this.comments = new ArrayList<Message>();
		this.createdBy = "N/A"; 
		this.createdOn = LocalDateTime.now();
		this.questionOption2 = ""; 
		this.questionOption3 = ""; 
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
	public List<Message> getComments() {
		return comments;
	}
	public void setComments(List<Message> comments) {
		this.comments = comments;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public String getQuestionOption1() {
		return questionOption1;
	}
	public void setQuestionOption1(String questionOption1) {
		this.questionOption1 = questionOption1;
	}
	public String getQuestionOption2() {
		return questionOption2;
	}
	public void setQuestionOption2(String questionOption2) {
		this.questionOption2 = questionOption2;
	}
	public String getQuestionOption3() {
		return questionOption3;
	}
	public void setQuestionOption3(String questionOption3) {
		this.questionOption3 = questionOption3;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "TestQuestion [questionId=" + questionId + ", questionText=" + questionText + ", questionAnswer="
				+ questionAnswer + ", questionOption1=" + questionOption1 + ", questionOption2=" + questionOption2
				+ ", questionOption3=" + questionOption3 + ", pointsPossible=" + pointsPossible + ", explanation="
				+ explanation + ", flags=" + flags + ", comments=" + comments + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + "]";
	}
	
	

}
