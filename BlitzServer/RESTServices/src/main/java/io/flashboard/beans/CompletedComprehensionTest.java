package io.flashboard.beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CompletedComprehensionTest extends ComprehensionTest {
	
	//TODO map this to User
	@Column
	private boolean completed;
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private User tester;
	//TODO Maybe need mapping
	private List<String> answersSubmitted;
	@Column
	private int score;
	@Column
	private float scorePercentage;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER, targetEntity=User.class)
	@JoinColumn(name="USER_ID")
	private Integer testTakerId; 
	
	
	

	public CompletedComprehensionTest(boolean completed, List<String> answersSubmitted, int score,
			float scorePercentage) {
		super();
	}

	public CompletedComprehensionTest() {
		super();
		
	}

	public CompletedComprehensionTest(int testId, String testTitle, String subject, String description,
			List<TestQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<CommentFlag> flags, List<Message> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testId, testTitle, subject, description, questions, creatorId, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}

	public CompletedComprehensionTest(int testId, String testTitle, String subject, String description,
			LocalDateTime createdOn, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testId, testTitle, subject, description);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}

	public CompletedComprehensionTest(String testTitle, String subject, String description,
			List<TestQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<CommentFlag> flags, List<Message> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testTitle, subject, description, questions, creatorId, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		
	}
	
	

}
