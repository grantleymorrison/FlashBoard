package io.flashboard.beans.studyguide;

import java.io.Serializable;
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

@Entity
@Table(name="COMMENT_SG")
public class CommentSG implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Properties
	@Id
	@SequenceGenerator(sequenceName="COMMENT_SEQ", name="COMMENT_SEQ")
	@GeneratedValue(generator="COMMENT_SEQ", strategy=GenerationType.SEQUENCE)
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=StudyGuide.class)
	private int commentId;
	
	// TODO After creating User object connect via ManyToOne
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="CREATED_DATE")
	private LocalDateTime createdDate;
	
	@Column(name="CONTENT")
	private String content;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=StudyGuide.class)
	@JoinColumn(name="THIS_GUIDE_ID")
	private Integer guideId;
	
	
	// Contructor using no arg
	public CommentSG() {
		super();
	}
	
	// Constrctor using no commentId
	public CommentSG(String username, String content) {
		super();
		this.username = username;
		this.createdDate = LocalDateTime.now();
		this.content = content;
	}

	
	// Constructor using all fields
	public CommentSG(int commentId, String username, LocalDateTime createdDate, String content, Integer studyGuideId) {
		super();
		this.commentId = commentId;
		this.username = username;
		this.createdDate = createdDate;
		this.content = content;
		this.guideId = studyGuideId;
	}

	
	// Override methods
	@Override
	public String toString() {
		return "CommentSG [commentId=" + commentId + ", username=" + username + ", createdDate=" + createdDate
				+ ", content=" + content + ", studyGuideId=" + guideId + "]";
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

	public Integer getStudyGuideId() {
		return guideId;
	}

	public void setStudyGuideId(Integer studyGuideId) {
		this.guideId = studyGuideId;
	}

	

	
}
