package io.flashboard.beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPREHENSION_TEST")
public class ComprehensionTest {
	@Id
	@Column(name="TEST_ID")
	@SequenceGenerator(sequenceName="TEST_SEQ", name="TEST_SEQ") //seqe for incrementing id 
	@GeneratedValue(generator="TEST_SEQ", strategy=GenerationType.SEQUENCE)
	private int testId; 
	@Column(name="TEST_TITLE")
	private String testTitle;
	@Column(name="TEST_SUBJECT")
	private String subject;
	@Column(name="TEST_DESC")
	private String description;
	@Column(name="TEST_QUESTIONS")
	private List<TestQuestion> questions;
	@Column(name="CREATOR_ID")
	private String creatorId;
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	@Column(name="MAX_SCORE")
	private int maxScore; 
	@Column(name="TOTAL_ATTEMPTS")
	private static int totalAttempts;
	@Column(name="FLAGS")
	private List<CommentFlag> flags;
	@Column(name="COMMENTS")
	private List<Message> comments;
	
	
	
	
	
	
	public ComprehensionTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ComprehensionTest(int testId, String testTitle, String subject, String description) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.subject = subject;
		this.description = description;
		this.createdOn = LocalDateTime.now();
	}




	public ComprehensionTest(String testTitle, String subject, String description, List<TestQuestion> questions,
			String creatorId, int maxScore, List<CommentFlag> flags,
			List<Message> comments) {
		super();
		this.testTitle = testTitle;
		this.subject = subject;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.now();
		this.maxScore = maxScore;
		this.flags = flags;
		this.comments = comments;
	}
	
	


	public ComprehensionTest(int testId, String testTitle, String subject, String description,
			List<TestQuestion> questions, String creatorId, int maxScore,
			List<CommentFlag> flags, List<Message> comments) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.subject = subject;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.now();;
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
	public List<Message> getComments() {
		return comments;
	}
	public void setComments(List<Message> comments) {
		this.comments = comments;
	}
	
	
	

}
