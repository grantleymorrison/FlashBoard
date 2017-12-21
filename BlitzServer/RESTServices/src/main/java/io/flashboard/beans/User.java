package io.flashboard.beans;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "User")
public class User extends AbstractUser {
	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(sequenceName = "USER_SEQ", name = "USER_SEQ") // seqe for incrementing id
	@GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer userId;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column
	private String email;

	@Column(name = "FAV_COLOR")
	private String favColor;

	@Column
	private String username;
	
	@Column
	private String password;
	

	@Column(name = "TESTS_TAKEN")
	private Integer testsTaken;
	@Column(name = "AVG_SCORE")
	private Double avgScore;
	@Column(name = "TAKEN_TESTS")
	private List<CompletedComprehensionTest> takenTests;
	
	@Column
	private Boolean approved;
	
	@Column
	private Boolean blacklisted;
	
	@Column
	private Boolean writer;

	public User() {
		this.testsTaken = 0;
		this.avgScore = 0.0;
		this.approved = false;
		this.blacklisted = false;
		this.writer = false;
		this.takenTests = new ArrayList<CompletedComprehensionTest>(testsTaken);
	}

	public User(String username , String password) {
		super(username, password);
		this.testsTaken = 0;
		this.avgScore = 0.0;
		this.approved = false;
		this.blacklisted = false;
		this.writer = false;
		this.takenTests = new ArrayList<CompletedComprehensionTest>(testsTaken);
	}

	public User(Integer userId, String username, String password, String firstName, String lastName, String email,
			String username2, String password2) {
		super(userId, username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		username = username2;
		password = password2;
		this.testsTaken = 0;
		this.avgScore = 0.0;
		this.approved = false;
		this.blacklisted = false;
		this.writer = false;
		this.takenTests = new ArrayList<CompletedComprehensionTest>(testsTaken);
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

	public List<CompletedComprehensionTest> getTakenTests() {
		return takenTests;
	}

	public void addTakenTests(CompletedComprehensionTest takenTest) {
		this.takenTests.add(takenTest);
	}

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

	public Boolean getWriter() {
		return writer;
	}

	public void setWriter(Boolean writer) {
		this.writer = writer;
	}

}
