package io.flashboard.beans.quiz;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "QUIZ")
public class Quiz {
	@Id
	@Column(name="QUIZ_ID")
	@SequenceGenerator(sequenceName="QUIZ_SEQ", name="QUIZ_SEQ") //seqe for incrementing id 
	@GeneratedValue(generator="QUIZ_SEQ", strategy=GenerationType.SEQUENCE)
	private int quizId; 
	@Column(name="QUIZ_TITLE")
	private String quizTitle;
	@Column(name="QUIZ_SUBJECT")
	private String topic;
	@Column(name="QUIZ_DESC")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Column(name = "QUESTIONS")
	private Set<QuizQuestion> questions;
	
	@Column(name="CREATOR_ID")
	private String creatorId;
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	@Column(name="MAX_SCORE")
	private int maxScore; 
	@Column(name="TOTAL_ATTEMPTS")
	private static int totalAttempts;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Column(name="RATINGS")
	private Set<Rating> ratings;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="COMMENT")
	private Set<Comment> comments;
		
	/**
	 * No-args constructor
	 */
	public Quiz() {

		this.quizTitle = "TITLE";
		this.topic = "TOPIC";
		this.description = "DESCRIPTION"; 

		this.maxScore = 10; 
		this.creatorId = "Default"; 
		this.createdOn = LocalDateTime.now();
		this.comments = new HashSet<Comment>();
		this.ratings = new HashSet<Rating>(); 
		this.questions = new HashSet<QuizQuestion>();
	}
		
	/**
	 * Constructor using only text-oriented fields.
	 * @param quizTitle
	 * @param topic
	 * @param description
	 */
	public Quiz(String quizTitle, String topic, String description) {
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.createdOn = LocalDateTime.now();

		this.questions = new HashSet<QuizQuestion>();
		this.maxScore = 10; 
		this.creatorId = "Default"; 
		this.comments = new HashSet<Comment>();
		this.ratings = new HashSet<Rating>(); 
	}



	/**
	 * Constructor with params for all member fields but quizId
	 * @param quizTitle
	 * @param topic
	 * @param description
	 * @param questions
	 * @param creatorId
	 * @param maxScore
	 * @param ratings
	 * @param comments
	 */
	public Quiz(String quizTitle, String topic, String description, Set<QuizQuestion> questions,
			String creatorId, int maxScore) {
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.now();
		this.maxScore = maxScore;
		this.comments = new HashSet<Comment>();
		this.ratings = new HashSet<Rating>(); 
	}
	
	public Quiz(String quizTitle, String topic, String description,
			String creatorId, int maxScore) {
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.questions = new HashSet<QuizQuestion>();
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.now();
		this.maxScore = maxScore;
		this.comments = new HashSet<Comment>();
		this.ratings = new HashSet<Rating>(); 
	}

	/**
	 * Constructor using all fields
	 * @param quizId
	 * @param quizTitle
	 * @param topic
	 * @param description
	 * @param questions
	 * @param creatorId
	 * @param maxScore
	 * @param ratings
	 * @param comments
	 */
	public Quiz(int quizId, String quizTitle, String topic, String description,
			Set<QuizQuestion> questions, String creatorId, int maxScore,
			Set<Rating> ratings, Set<Comment> comments) {
		this.quizId = quizId;
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.now();;
		this.maxScore = maxScore;
		this.ratings = ratings;
		this.comments = comments;
	}
	
	public Quiz(int quizId, String quizTitle, String topic, String description,
			Set<QuizQuestion> questions, String creatorId, String createdOn, int maxScore,
			Set<Rating> ratings, Set<Comment> comments) {
		this.quizId = quizId;
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.parse(createdOn);
		this.maxScore = maxScore;
		this.ratings = ratings;
		this.comments = comments;
	}
	
	public Quiz( String quizTitle , String topic , String description ,
			Set<QuizQuestion> questions , String creatorId , int maxScore ,
			Set<Rating> ratings , Set<Comment> comments ) {
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.now();;
		this.maxScore = maxScore;
		this.ratings = ratings;
		this.comments = comments;
	}

	public int getTestId() {
		return quizId;
	}
	public void setTestId(int quizId) {
		this.quizId = quizId;
	}
	public String getTestTitle() {
		return quizTitle;
	}
	public void setTestTitle(String quizTitle) {
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
	public Set<QuizQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<QuizQuestion> questions) {
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
		Quiz.totalAttempts = totalAttempts;
	}
	public Set<Rating> getFlags() {
		return ratings;
	}
	public void setFlags(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	
	public void addQuestion(QuizQuestion question) {
		this.questions.add(question); 
	}
	public boolean removeQuestion(String questionText) {
		boolean removed = false; 
		for(QuizQuestion q : this.questions) {
			if(q.getQuestionText().equals(questionText))
				removed = questions.remove(q); 
		}
		return removed; 
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", "
				+ (quizTitle != null ? "quizTitle=" + quizTitle + ", " : "")
				+ (topic != null ? "topic=" + topic + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (questions != null ? "questions=" + questions + ", " : "")
				+ (creatorId != null ? "creatorId=" + creatorId + ", " : "")
				+ (createdOn != null ? "createdOn=" + createdOn + ", " : "") + "maxScore="
				+ maxScore + ", " + (ratings != null ? "ratings=" + ratings + ", " : "")
				+ (comments != null ? "comments=" + comments : "") + "]";
	}


	

}
