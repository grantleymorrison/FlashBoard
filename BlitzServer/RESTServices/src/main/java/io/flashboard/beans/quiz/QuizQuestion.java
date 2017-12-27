package io.flashboard.beans.quiz;

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
import javax.persistence.Table;

import io.flashboard.beans.users.Message;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "QUESTIONS")
public  class QuizQuestion {
	



	@Id
	@Column(name = "QUESTION_ID")
	@SequenceGenerator(sequenceName = "QUESTION_SEQ", name = "QUESTION_SEQ")	
	@GeneratedValue(generator = "QUESTION_SEQ", strategy = GenerationType.SEQUENCE)		
	private int questionId;
	
	@Column(name = "QUESTION_TEXT")
	private String questionText;
	
	@Column(name = "TOPIC")
	private String topic; 


	@Column(name = "OPTIONS")
	private ArrayList<String> options; 
	
	@Column(name = "ANSWER")
	private String answer; 
	
	@Column(name = "POINTS_POSSIBLE")
	private int pointsPossible; 
	
	@Column
	private String explanation; 
	
	@OneToMany(fetch=FetchType.EAGER, orphanRemoval = true)
	@Column(name = "RATINGS")
	private List<Rating> ratings;
	
	@OneToMany(fetch=FetchType.EAGER, orphanRemoval = true)
	@Column(name = "COMMENTS")
	private List<Message> comments;
	
	@Column 
	private String createdBy; 
	
	@Column 
	private LocalDateTime createdOn; 
	
	
	
	
	public QuizQuestion() {
		this.questionText = ""; 
		this.topic = "UNSORTED"; 
		this.options = new ArrayList<String>(); 
		this.answer = ""; 
		this.pointsPossible = 0; 
		this.explanation = ""; 
		this.ratings = new ArrayList<Rating>(); 
		this.comments = new ArrayList<Message>(); 
		this.createdBy = "N/A"; 
		this.createdOn = LocalDateTime.now(); 
	}
	
	
	
	public QuizQuestion(int questionId, String questionText, String topic, ArrayList<String> options, String answer,
			int pointsPossible, String explanation, List<Rating> ratings, List<Message> comments, String createdBy,
			LocalDateTime createdOn) {
		this.questionId = questionId;
		this.questionText = questionText;
		this.topic = topic;
		this.options = options;
		this.answer = answer;
		this.pointsPossible = pointsPossible;
		this.explanation = explanation;
		this.ratings = ratings;
		this.comments = comments;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
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
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public List<Message> getComments() {
		return comments;
	}
	public void setComments(List<Message> comments) {
		this.comments = comments;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	public void setOptions(String[] strs) {
		this.options.toArray(strs); 
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	@Override
	public String toString() {
		return "TestQuestion [questionId=" + questionId + ", questionText=" + questionText + ", topic=" + topic
				+ ", options=" + options + ", answer=" + answer + ", pointsPossible=" + pointsPossible
				+ ", explanation=" + explanation + ", ratings=" + ratings + ", comments=" + comments + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + "]";
	}

	
	

}
