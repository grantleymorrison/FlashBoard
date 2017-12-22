package io.flashboard.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "QUIZ")
public class ComprehensionTest {
	@Id
	@Column(name="QUIZ_ID")
	@SequenceGenerator(sequenceName="QUIZ_SEQ", name="QUIZ_SEQ") //seqe for incrementing id 
	@GeneratedValue(generator="QUIZ_SEQ", strategy=GenerationType.SEQUENCE)
	private int testId; 
	@Column(name="QUIZ_TITLE")
	private String testTitle;
	@Column(name="QUIZ_SUBJECT")
	private String topic;
	@Column(name="QUIZ_DESC")
	private String description;
	
	//TODO map this to TestQuestion
	@OneToMany(fetch=FetchType.EAGER, orphanRemoval = false)
	@Column(name = "QUESTIONS")
	private List<TestQuestion> questions;
	
	@Column(name="CREATOR_ID")
	private String creatorId;
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	@Column(name="MAX_SCORE")
	private int maxScore; 
	@Column(name="TOTAL_ATTEMPTS")
	private static int totalAttempts;
	
	//TODO map this to commentflag
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name="FLAGS")
	private List<CommentFlag> flags;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name="COMMENTS")
	private List<Message> comments;
		
	public ComprehensionTest() {

		this.testTitle = "TITLE";
		this.topic = "TOPIC";
		this.description = "DESCRIPTION"; 

		this.maxScore = 0; 
		this.creatorId = "N/A"; 
		this.createdOn = LocalDateTime.now();
		this.comments = new ArrayList<Message>();
		this.flags = new ArrayList<CommentFlag>(); 
		this.questions = new ArrayList<TestQuestion>();
	}
		
	public ComprehensionTest(String testTitle, String subject, String description) {
		this.testTitle = testTitle;
		this.topic = subject;
		this.description = description;
		this.createdOn = LocalDateTime.now();

		this.questions = new ArrayList<TestQuestion>();
		this.maxScore = 0; 
		this.creatorId = "N/A"; 
		this.comments = new ArrayList<Message>();
		this.flags = new ArrayList<CommentFlag>(); 
	}




	public ComprehensionTest(String testTitle, String subject, String description, List<TestQuestion> questions,
			String creatorId, int maxScore, List<CommentFlag> flags, List<Message> comments) {
		this.testTitle = testTitle;
		this.topic = subject;
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
		this.testId = testId;
		this.testTitle = testTitle;
		this.topic = subject;
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
		return topic;
	}
	public void setSubject(String subject) {
		this.topic = subject;
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
	
	
	public void addQuestion(TestQuestion question) {
		this.questions.add(question); 
	}

	@Override
	public String toString() {
		String str = "ComprehensionTest [testId=" + testId + ", testTitle=" + testTitle + ", topic=" + topic
				+ ", description=" + description + ", questions=\n";
		for(TestQuestion tq : questions) str += "\t" + tq + "\n";
		str += "creatorId=" + creatorId
				+ ", createdOn=" + createdOn + ", maxScore=" + maxScore + ", flags=" + flags + ", comments=" + comments
				+ "]";
		return str; 
	}
	

}
