package io.flashboard.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CommentFlag {
	
	@Id
	@SequenceGenerator(sequenceName="CF_SEQ", name="CF_SEQ")
	@GeneratedValue(generator="CF_SEQ", strategy=GenerationType.SEQUENCE)
	private int commentId;
	
	@Column 
	private String flagTag; 
	

	public CommentFlag() {
		super();
	}


	public int getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public String getFlagTag() {
		return flagTag;
	}


	public void setFlagTag(String flagTag) {
		this.flagTag = flagTag;
	}


	@Override
	public String toString() {
		return "CommentFlag [commentId=" + commentId + ", flagTag=" + flagTag + "]";
	}


	public CommentFlag(int commentId, String flagTag) {
		this.commentId = commentId;
		this.flagTag = flagTag;
	}


	public CommentFlag(String flagTag) {
		super();
		this.flagTag = flagTag;
	}
	
	
	
}
