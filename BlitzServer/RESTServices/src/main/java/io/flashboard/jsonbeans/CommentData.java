package io.flashboard.jsonbeans;

import java.time.LocalDateTime;

public class CommentData {
	private int commentId;
	private String username;
	private LocalDateTime createdDate;
	private String content;
	
	//All args
	public CommentData(int commentId, String username, LocalDateTime createdDate, String content) {
		super();
		this.commentId = commentId;
		this.username = username;
		this.createdDate = createdDate;
		this.content = content;
	}
	
	//No args
	public CommentData() {
		
	}

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

	@Override
	public String toString() {
		return "CommentData [commentId=" + commentId + ", username=" + username + ", createdDate=" + createdDate
				+ ", content=" + content + "]";
	}
	
	
}
