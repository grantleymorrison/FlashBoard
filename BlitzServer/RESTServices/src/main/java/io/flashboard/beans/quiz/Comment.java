package io.flashboard.beans.quiz;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.flashboard.beans.studyguide.StudyGuide;

@Entity
@Table(name="COMMENT_QZ")
public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2060364884767994321L;

	// Properties
	@Id
	@SequenceGenerator(sequenceName="COMMENT_SEQ", name="COMMENT_SEQ")
	@GeneratedValue(generator="COMMENT_SEQ", strategy=GenerationType.SEQUENCE)
	private int commentId;
	
	// TODO After creating User object connect via ManyToOne
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="CREATED_DATE")
	private LocalDateTime createdDate;
	
	@Column(name="CONTENT")
	private String content;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=Quiz.class)
	@JoinColumn(name="THIS_QUIZ_ID")
	private Integer quizId;
	
	
	// Contructor using no arg
	public Comment() {
		super();
	}
	
	// Constrctor using no commentId
	public Comment(String username, String content) {
		super();
		this.username = username;
		this.createdDate = LocalDateTime.now();
		this.content = content;
	}

	
	// Constructor using all fields
	public Comment(int commentId, String username, LocalDateTime createdDate, String content, Integer quizId) {
		super();
		this.commentId = commentId;
		this.username = username;
		this.createdDate = createdDate;
		this.content = content;
		this.quizId = quizId;
	}
	
	// Override methods
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", username=" + username + ", createdDate=" + createdDate
				+ ", content=" + content + ", quizId=" + quizId + "]";
	}


	// Getters and setters
	public int getCommentId() {
		return commentId;
	}
	
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	
	
	
}
