package io.flashboard.beans;

/*
 * This class is an abstraction of all of the possible users that can be created. Every user will be able to make use of these fields.
 */
public abstract class AbstractUser {
	private Integer userId;
	private String username;
	private String password;
	
	public AbstractUser (Integer userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	public AbstractUser (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public AbstractUser() {
		
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
}
