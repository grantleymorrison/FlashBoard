package io.flashboard.beans.quiz;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Comment {
	
	// Properties
	@Id
	@Column(name="COMMENT_ID")
	@SequenceGenerator(sequenceName="COMMENT_SEQ", name="COMMENT_SEQ")
	@GeneratedValue(generator="COMMENT_SEQ", strategy=GenerationType.SEQUENCE)
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private int commentId;
	
	// TODO After creating User object connect via ManyToOne
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="CONTENT")
	private String content;
	
	
	// Contructor using no arg
	public Comment() {
		super();
	}
	
	// Constrctor using no commentId
	public Comment(String username, LocalDate createdDate, String content) {
		super();
		this.username = username;
		this.createdDate = createdDate;
		this.content = content;
	}

	
	// Constructor using all fields
	public Comment(int commentId, String username, LocalDate createdDate, String content) {
		super();
		this.commentId = commentId;
		this.username = username;
		this.createdDate = createdDate;
		this.content = content;
	}
	
	// Override methods
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", username=" + username + ", createdDate=" + createdDate
				+ ", content=" + content + "]";
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
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
