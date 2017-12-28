package io.flashboard.beans.quiz;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.flashboard.beans.users.Message;
import io.flashboard.beans.users.User;

@Entity
@Table(name = "FINISHED_QUIZ")
public class TakenQuiz extends Quiz {
	
	//TODO map this to User
	@Column
	private boolean completed;

	@ElementCollection
	@Column(name = "SUBMITTED_ANSWERS")
	private List<String> answersSubmitted;
	
	@Column
	private int score;
	
	@Column
	private float scorePercentage;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER, targetEntity=User.class)
	@JoinColumn(name="USER_ID")
	private Integer testTakerId; 
	
	@Column 
	private LocalDateTime completedOn; 
	

	public TakenQuiz(boolean completed, List<String> answersSubmitted, int score,
			float scorePercentage) {
		super();
	}

	public TakenQuiz() {
		super();
		
	}

	public TakenQuiz(int testId, String testTitle, String topic, String description,
			List<QuizQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<Rating> flags, List<Comment> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testId, testTitle, topic, description, questions, creatorId, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}

	public TakenQuiz(int testId, String testTitle, String topic, String description,
			LocalDateTime createdOn, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testTitle, topic, description);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}

	public TakenQuiz(String testTitle, String topic, String description,
			List<QuizQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<Rating> flags, List<Comment> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testTitle, topic, description, questions, creatorId, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}
	
	

}
