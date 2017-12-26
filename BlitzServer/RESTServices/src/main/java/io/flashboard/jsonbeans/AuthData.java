package io.flashboard.jsonbeans;

public class AuthData {
	private String token;
	private int userRole;
	
	//One arg
	public AuthData(int userRole) {
		super();
		this.token = "Some Token";
		this.userRole = userRole;
	}

	//No args
	public AuthData() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "AuthData [token=" + token + ", userRole=" + userRole + "]";
	}

}
