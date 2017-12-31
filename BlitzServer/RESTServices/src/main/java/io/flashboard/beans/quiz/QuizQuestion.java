package io.flashboard.beans.quiz;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.flashboard.beans.users.Message;

@Entity
@Table(name = "QUESTIONS")
public  class QuizQuestion implements Serializable {
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 473973045234517174L;

	@Id
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=Quiz.class)
	@SequenceGenerator(sequenceName = "QUESTION_SEQ", name = "QUESTION_SEQ")	
	@GeneratedValue(generator = "QUESTION_SEQ", strategy = GenerationType.SEQUENCE)		
	private int questionId;
	
	@Column(name = "QUESTION_TEXT")
	private String questionText;
	
	@Column(name = "TOPIC")
	private String topic; 

	@Column(name = "OPTIONS")
	private HashSet<String> options; 
	
	@Column(name = "ANSWER")
	private String answer; 
	
	@Column(name = "POINTS_POSSIBLE")
	private int pointsPossible; 
	
	@Column
	private String explanation; 
	
	@OneToMany(orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Column(name = "RATINGS")
	private Set<Rating> ratings;
	
	@Column 
	private String createdBy; 
	
	@Column 
	private LocalDateTime createdOn; 
	
	
	
	
	public QuizQuestion() {
		this.questionText = ""; 
		this.topic = "UNSORTED"; 
		this.options = new HashSet<String>(); 
		this.answer = ""; 
		this.pointsPossible = 2; 
		this.explanation = ""; 
		this.ratings = new HashSet<Rating>(); 
		this.createdBy = "Default"; 
		this.createdOn = LocalDateTime.now(); 
	}
	
	
	public QuizQuestion(String questionText, String topic, HashSet<String> options, String answer) {
		this.questionText = questionText;
		this.topic = topic;
		this.options = options;
		this.answer = answer;
		this.pointsPossible = 2; 
		this.explanation = ""; 
		this.ratings = new HashSet<Rating>(); 
		this.createdBy = "Default"; 
		this.createdOn = LocalDateTime.now();
	}
	
	public QuizQuestion(String questionText, String topic, HashSet<String> options, String answer,
			int pointsPossible, String explanation, Set<Rating> ratings, String createdBy) {
		this.questionText = questionText;
		this.topic = topic;
		this.options = options;
		this.answer = answer;
		this.pointsPossible = pointsPossible;
		this.explanation = explanation;
		this.ratings = ratings;
		this.createdBy = createdBy;
		this.createdOn = LocalDateTime.now();
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
	public Set<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public HashSet<String> getOptions() {
		return options;
	}
	public void setOptions(HashSet<String> options) {
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
				+ ", explanation=" + explanation + ", ratings=" + ratings + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + "]";
	}

}
