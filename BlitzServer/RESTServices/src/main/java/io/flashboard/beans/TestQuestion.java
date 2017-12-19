package io.flashboard.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//TODO: Refactor Other Test Questions around this one

@Entity
@Table(name="TestQuestion")
public abstract class TestQuestion {
	
	@Id
	@Column(name = "QUESTION_ID")
	@SequenceGenerator(sequenceName = "QUESTION_SEQ", name = "QUESTION_SEQ")	
	@GeneratedValue(generator = "QUESTION_SEQ", strategy = GenerationType.SEQUENCE)		
	private int questionId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="FOR_TEST")
	private int testId;
	
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
	
	@Column
	private List<CommentFlag> flags;
	@Column
	private List<CommentMessage> comments;
	
	
	
	
	public TestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestQuestion( int testId , String questionText , String questionAnswer ,
			String questionOption1 , int pointsPossible , String explanation ) {
		this.testId = testId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.pointsPossible = pointsPossible;
		this.explanation = explanation;
	}
	public TestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, String questionOption2, 
			String questionOption3, int pointsPossible) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.questionOption2 = questionOption2;
		this.questionOption3 = questionOption3;
		this.pointsPossible = pointsPossible;
	}
	public TestQuestion(String questionText, String questionAnswer, String questionOption1, String questionOption2, 
			String questionOption3, int pointsPossible) {
		super();
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.questionOption2 = questionOption2;
		this.questionOption3 = questionOption3;
		this.pointsPossible = pointsPossible;
		this.flags = new ArrayList<CommentFlag>();
		this.comments = new ArrayList<CommentMessage>();
	}
	public TestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, String questionOption2, 
			String questionOption3, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments) {
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
	}
	public TestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, int pointsPossible,
			List<CommentFlag> flags, List<CommentMessage> comments) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.pointsPossible = pointsPossible;
		this.flags = flags;
		this.comments = comments;
	}
	
	public TestQuestion(int questionId, String questionText, String questionAnswer, String questionOption1, int pointsPossible) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
		this.pointsPossible = pointsPossible;
	}
	
	public TestQuestion(String questionText, String questionAnswer, String questionOption1, int pointsPossible, 
			List<CommentFlag> flags, List<CommentMessage> comments) {
		super();
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
		this.questionOption1 = questionOption1;
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
	public int getTestId() {
		return testId;
	}
	
	

}
