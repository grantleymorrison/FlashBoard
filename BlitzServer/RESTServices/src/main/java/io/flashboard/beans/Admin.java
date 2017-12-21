package io.flashboard.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	
	//TODO Redundant? Have user with different roleId
	
	@Id
	@Column(name="ADMIN_ID")
	@SequenceGenerator(sequenceName="ADMIN_SEQ", name="ADMIN_SEQ") //seqe for incrementing id 
	@GeneratedValue(generator="ADMIN_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer userId;
	@Column
	private String username;
	@Column
	private String password;
	
	
	
	public Admin( Integer userId , String username , String password ) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public Admin( String username , String password ) {
		this.username = username;
		this.password = password;
	}

	public Admin() {
		
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [" + (userId != null ? "userId=" + userId + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (password != null ? "password=" + password : "") + "]";
	}
	/*
	public void deleteComprehensionTestComment() {
		
	}
	*/
}
