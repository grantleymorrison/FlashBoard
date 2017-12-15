package io.flashboard.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * The basic user. Limited privileges.
 */
@Entity
@Table(name="User")
public class User extends AbstractUser {
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(sequenceName="USER_SEQ", name="USER_SEQ") //seqe for incrementing id 
	@GeneratedValue(generator="USER_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer userId;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private Integer testsTaken;
	private Double avgScore;
	/*private List<CompletedComprehensionTest> takenTests; */
	private Boolean approved;
	private Boolean blacklisted;
	
	public User( Integer userId , String username , String password, Integer testsTaken ) {
		super(userId, username, password);
		this.testsTaken = 0;
		this.avgScore = 0.0;
		/*this.takenTests = new ArrayList<CompletedComprehensionTest>(testsTaken);*/
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

	public Integer getTestsTaken() {
		return testsTaken;
	}

	public void setTestsTaken(Integer testsTaken) {
		this.testsTaken = testsTaken;
	}

	public Double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}

/*	public List<CompletedComprehensionTest> getTakenTests() {
		return takenTests;
	}

	public void addTakenTests(CompletedComprehensionTest takenTest) {
		this.takenTests.add(takenTest);
	}*/

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getBlacklisted() {
		return blacklisted;
	}

	public void setBlacklisted(Boolean blacklisted) {
		this.blacklisted = blacklisted;
	}


}
