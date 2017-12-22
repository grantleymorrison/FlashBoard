package io.flashboard.beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompletedComprehensionTest extends ComprehensionTest {
	
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
	

	public CompletedComprehensionTest(boolean completed, List<String> answersSubmitted, int score,
			float scorePercentage) {
		super();
	}

	public CompletedComprehensionTest() {
		super();
		
	}

	public CompletedComprehensionTest(int testId, String testTitle, String topic, String description,
			List<TestQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<CommentFlag> flags, List<Message> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testId, testTitle, topic, description, questions, creatorId, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}

	public CompletedComprehensionTest(int testId, String testTitle, String topic, String description,
			LocalDateTime createdOn, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testTitle, topic, description);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}

	public CompletedComprehensionTest(String testTitle, String topic, String description,
			List<TestQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<CommentFlag> flags, List<Message> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testTitle, topic, description, questions, creatorId, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}
	
	

}
