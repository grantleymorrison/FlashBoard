package io.flashboard.beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class CompletedComprehensionTest extends ComprehensionTest {
	
	@Column
	private boolean completed;
	@OneToMany(mappedBy = "testId", fetch = FetchType.EAGER)
	private List<String> answersSubmitted;
	@Column
	private int score;
	@Column
	private float scorePercentage;
	
	
	

	public CompletedComprehensionTest(boolean completed, List<String> answersSubmitted, int score,
			float scorePercentage) {
		super();
	}

	public CompletedComprehensionTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompletedComprehensionTest(int testId, String testTitle, String subject, String description,
			List<TestQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<CommentFlag> flags, List<CommentMessage> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testId, testTitle, subject, description, questions, creatorId, createdOn, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		// TODO Auto-generated constructor stub
	}

	public CompletedComprehensionTest(int testId, String testTitle, String subject, String description,
			LocalDateTime createdOn, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testId, testTitle, subject, description, createdOn);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		// TODO Auto-generated constructor stub
	}

	public CompletedComprehensionTest(String testTitle, String subject, String description,
			List<TestQuestion> questions, String creatorId, LocalDateTime createdOn, int maxScore,
			List<CommentFlag> flags, List<CommentMessage> comments, boolean completed, List<String> answersSubmitted, int score, float scorePercentage) {
		super(testTitle, subject, description, questions, creatorId, createdOn, maxScore, flags, comments);
		this.completed = completed;
		this.answersSubmitted = answersSubmitted;
		this.score = score;
		this.scorePercentage = scorePercentage;
		// TODO Auto-generated constructor stub
	}
	
	

}
