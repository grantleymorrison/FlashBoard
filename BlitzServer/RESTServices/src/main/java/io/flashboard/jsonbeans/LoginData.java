package io.flashboard.jsonbeans;

public class LoginData {
	private String username;
	private String password;
	
	//No args constructor needed for JSON to object translation
	public LoginData() {
		super();
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
