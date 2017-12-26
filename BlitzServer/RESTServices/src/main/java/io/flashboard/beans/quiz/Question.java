package io.flashboard.beans.quiz;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

	// Properties
	@Id
	@Column(name = "QUESTION_ID")
	@SequenceGenerator(sequenceName = "QUESTION_SEQ", name = "QUESTION_SEQ")
	@GeneratedValue(generator = "QUESTION_SEQ", strategy = GenerationType.SEQUENCE)
	private int questionId;

	@Column(name = "QUESTION")
	private String question;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity=Quiz.class)
	@JoinColumn(name = "QUIZ_REFERENCE")
	private Integer quizId;

	@Column(name = "OPTIONS")
	private String[] options;

	@Column(name = "ANSWER")
	private String answer;

	@Column(name = "POINTS")
	private int points;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RATING_ID")
	private Rating ratings;

	@OneToMany(mappedBy = "commentId", fetch = FetchType.EAGER)
	private List<Comment> comments;

	// Constructor using no fields
	public Question() {
		super();
	}

	// Constructor using no questionId
	public Question(String question, int quizId, String[] options, String answer, int points, Rating ratings,
			List<Comment> comments) {
		super();
		this.question = question;
		this.quizId = quizId;
		this.options = options;
		this.answer = answer;
		this.points = points;
		this.ratings = ratings;
		this.comments = comments;
	}

	// Constructor using all fields
	public Question(int questionId, String question, int quizId, String[] options, String answer, int points,
			Rating ratings, List<Comment> comments) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.quizId = quizId;
		this.options = options;
		this.answer = answer;
		this.points = points;
		this.ratings = ratings;
		this.comments = comments;
	}

	// Override methods
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", quizId=" + quizId + ", options="
				+ options + ", answer=" + answer + ", points=" + points + ", ratings=" + ratings + ", comments="
				+ comments + "]";
	}

	// Getters and setters
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Rating getRatings() {
		return ratings;
	}

	public void setRatings(Rating ratings) {
		this.ratings = ratings;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

}
