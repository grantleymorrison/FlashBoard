package io.flashboard.jsonbeans;

public class ProfileData {
	private String username;
	private String fName;
	private String lName;
	private String email;
	private String favColor;
	private double avgScore;
	private int role;
	
	//No args constructor for JSON to object conversion
	public ProfileData() {
		super();
	}
	
	//Wrong token constructor
	public ProfileData(String username) {
		super();
		this.username = username;
	}

	//All args constructor 
	public ProfileData(String username, String fName, String lName, String email, 
			String favColor, double avgScore, int role) {
		super();
		this.username = username;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.favColor = favColor;
		this.avgScore = avgScore;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFavColor() {
		return favColor;
	}
	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ProfileData [username=" + username + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", favColor=" + favColor + ", avgScore=" + avgScore + ", role=" + role + "]";
	}
	
	
	
}
