package io.flashboard.beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class ComprehensionTest {
	
	@Id
	@Column(name = "TEST_ID")
	@SequenceGenerator(sequenceName = "TEST_SEQ", name = "TEST_SEQ")	
	@GeneratedValue(generator = "TEST_SEQ", strategy = GenerationType.SEQUENCE)	
	private int testId; 
	
	@Column
	private String testTitle;
	
	@Column
	private String subject;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="testId", fetch=FetchType.EAGER)
	private List<TestQuestion> questions;
	
	@Column
	private String creatorId;
	
	@Column
	private LocalDateTime createdOn;
	
	@Column
	private int maxScore; 
	
	@Column
	private static int totalAttempts;
	
	
	private List<CommentFlag> flags;
	private List<CommentMessage> comments;
	
	
	
	
	
	
	public ComprehensionTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ComprehensionTest(int testId, String testTitle, String subject, String description,
			LocalDateTime createdOn) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.subject = subject;
		this.description = description;
		this.createdOn = createdOn;
	}




	public ComprehensionTest(String testTitle, String subject, String description, List<TestQuestion> questions,
			String creatorId, LocalDateTime createdOn, int maxScore, List<CommentFlag> flags,
			List<CommentMessage> comments) {
		super();
		this.testTitle = testTitle;
		this.subject = subject;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = createdOn;
		this.maxScore = maxScore;
		this.flags = flags;
		this.comments = comments;
	}
	
	


	public ComprehensionTest(int testId, String testTitle, String subject, String description,
			List<TestQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<CommentFlag> flags, List<CommentMessage> comments) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.subject = subject;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = createdOn;
		this.maxScore = maxScore;
		this.flags = flags;
		this.comments = comments;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<TestQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<TestQuestion> questions) {
		this.questions = questions;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public static int getTotalAttempts() {
		return totalAttempts;
	}
	public static void setTotalAttempts(int totalAttempts) {
		ComprehensionTest.totalAttempts = totalAttempts;
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
