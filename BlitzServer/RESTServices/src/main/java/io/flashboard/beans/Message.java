package io.flashboard.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE")

public class Message {
	@Id //designates primary key
	@Column(name="MESSAGE_ID") //defaults to using the name of the int
	@SequenceGenerator(sequenceName="MESSAGE_SEQ", name="MESSAGE_SEQ") //seqe for incrementing id 
	@GeneratedValue(generator="MESSAGE_SEQ", strategy=GenerationType.SEQUENCE)
	private int messageId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="CONTENT")
	private String content;
	
	
	public Message( int userId , int messageId , String message ) {
		this.userId = userId;
		this.messageId = messageId;
		this.content = message;
	}
	

	public Message(int userId, String content) {
		this.userId = userId;
		this.content = content;
	}


	public Message(){
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return content;
	}

	public void setMessageContent(String message) {
		this.content = message;
	}
	
	
}
