package io.flashboard.beans;

public class RegistrationData {
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String rePassword;
	private String email;
	private String favColor;
	
	public RegistrationData() {
		super();
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFavColor() {
		return favColor;
	}

	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}
	
	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	@Override
	public String toString() {
		return "RegistrationData [fname=" + fname + ", lname=" + lname + ", username=" + username + ", password="
				+ password + ", email=" + email + ", favColor=" + favColor + "]";
	}


	
}
