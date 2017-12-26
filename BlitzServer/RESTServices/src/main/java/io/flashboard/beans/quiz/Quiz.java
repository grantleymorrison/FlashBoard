package io.flashboard.beans.quiz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@Table(name="QUIZ")
public class Quiz {
	
	// Properties
	@Id
	@Column(name="QUIZ_ID")
	@SequenceGenerator(sequenceName="QUIZ_SEQ", name="QUIZ_SEQ")
	@GeneratedValue(generator="QUIZ_SEQ", strategy=GenerationType.SEQUENCE)
	private int quizId;
	
	@Column(name="QUIZ_TITLE")
	private String quizTitle;
	
	@Column(name="TOPIC")
	private String topic;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="MAX_SCORE")
	private int maxScore;
	
	@Column(name="TOTAL_ATTEMPT")
	private int totalAttempts;
	
	@OneToMany(mappedBy="quizId", fetch=FetchType.EAGER)
	private List<Question> questions = new ArrayList<>();
	
	@OneToMany(mappedBy="commentId", fetch=FetchType.EAGER)
	private List<Comment> comments;
	
	// Constructors
	// Contructor using no arg
	public Quiz() {
		super();
	}
	
	// Constructor using no quizId
	public Quiz(String quizTitle, String topic, String description, String username, LocalDate createdDate,
			int maxScore, int totalAttempts, List<Question> questions, List<Comment> comments) {
		super();
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.username = username;
		this.createdDate = createdDate;
		this.maxScore = maxScore;
		this.totalAttempts = totalAttempts;
		this.questions = questions;
		this.comments = comments;
	}

	// Constructor using all fields
	public Quiz(int quizId, String quizTitle, String topic, String description, String username, LocalDate createdDate,
			int maxScore, int totalAttempts, List<Question> questions, List<Comment> comments) {
		super();
		this.quizId = quizId;
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.username = username;
		this.createdDate = createdDate;
		this.maxScore = maxScore;
		this.totalAttempts = totalAttempts;
		this.questions = questions;
		this.comments = comments;
	}

	// Override methods
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizTitle=" + quizTitle + ", topic=" + topic + ", description="
				+ description + ", username=" + username + ", createdDate=" + createdDate + ", maxScore=" + maxScore
				+ ", totalAttempts=" + totalAttempts + ", questions=" + questions + ", comments=" + comments + "]";
	}
	

	// Getters and Setters
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public int getTotalAttempts() {
		return totalAttempts;
	}
	public void setTotalAttempts(int totalAttempts) {
		this.totalAttempts = totalAttempts;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
