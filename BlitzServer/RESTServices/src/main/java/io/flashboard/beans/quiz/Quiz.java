package io.flashboard.beans.quiz;

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
	
	@OneToMany(fetch=FetchType.EAGER, orphanRemoval = false)
	@Column(name = "QUESTIONS")
	private List<QuizQuestion> questions;
	
	@Column(name="CREATOR_ID")
	private String creatorId;
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	@Column(name="MAX_SCORE")
	private int maxScore; 
	@Column(name="TOTAL_ATTEMPTS")
	private static int totalAttempts;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name="RATINGS")
	private List<Rating> ratings;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name="COMMENTS")
	private List<Comment> comments;
		
	/**
	 * No-args constructor
	 */
	public Quiz() {

		this.quizTitle = "TITLE";
		this.topic = "TOPIC";
		this.description = "DESCRIPTION"; 

		this.maxScore = 0; 
		this.creatorId = "N/A"; 
		this.createdOn = LocalDateTime.now();
		this.comments = new ArrayList<Comment>();
		this.ratings = new ArrayList<Rating>(); 
		this.questions = new ArrayList<QuizQuestion>();
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

		this.questions = new ArrayList<QuizQuestion>();
		this.maxScore = 0; 
		this.creatorId = "N/A"; 
		this.comments = new ArrayList<Comment>();
		this.ratings = new ArrayList<Rating>(); 
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
	public Quiz(String quizTitle, String topic, String description, List<QuizQuestion> questions,
			String creatorId, int maxScore, List<Rating> ratings, List<Comment> comments) {
		this.quizTitle = quizTitle;
		this.topic = topic;
		this.description = description;
		this.questions = questions;
		this.creatorId = creatorId;
		this.createdOn = LocalDateTime.now();
		this.maxScore = maxScore;
		this.ratings = ratings;
		this.comments = comments;
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
			List<QuizQuestion> questions, String creatorId, int maxScore,
			List<Rating> ratings, List<Comment> comments) {
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
	public List<QuizQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuizQuestion> questions) {
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
	public List<Rating> getFlags() {
		return ratings;
	}
	public void setFlags(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
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
		String str = "ComprehensionTest [quizId=" + quizId + ", quizTitle=" + quizTitle + ", topic=" + topic
				+ ", description=" + description + ", questions=\n";
		for(QuizQuestion tq : questions) str += "\t" + tq + "\n";
		str += "creatorId=" + creatorId
				+ ", createdOn=" + createdOn + ", maxScore=" + maxScore + ", ratings=" + ratings + ", comments=" + comments
				+ "]";
		return str; 
	}
	

}
