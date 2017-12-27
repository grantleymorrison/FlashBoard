package io.flashboard.beans.users;

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
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="CONTENT")
	private String content;
	
	
	public Message( String username , int messageId , String message ) {
		this.username = username;
		this.messageId = messageId;
		this.content = message;
	}
	

	public Message(String username, String content) {
		this.username = username;
		this.content = content;
	}


	public Message(){
		
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
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
