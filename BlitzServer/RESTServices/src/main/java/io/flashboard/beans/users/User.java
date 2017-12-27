package io.flashboard.beans.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.flashboard.beans.quiz.TakenQuiz;

/*
 * The basic user. Limited privileges.
 */
@Entity
@Table(name = "Users")
public class User {
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

	@Column(unique = true)
	private String username;
	
	@Column
	private String password;
	
	@Column(name = "AVG_SCORE")
	private Double avgScore;
  
	//TODO map user to completed test New Stuff!!!!!!!!!!
	@OneToMany(orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Column(name="TAKEN_TESTS")
	private List<TakenQuiz> takenTests;
	
	@Column(name = "ACCOUNT_IS_APPROVED")
	private Boolean approved;
	
	@Column(name = "IS_BLACKLISTED")
	private Boolean blacklisted;
	
	@Column	//0: base user; 1: writer; 2: admin
	private Integer roleFlag; 

	public User() {
		this.firstName = "N/A";
		this.lastName = "N/A";
		this.email = "N/A";
		this.username = "N/A";
		this.password = "N/A";
		this.avgScore = 0.0;
		this.approved = false;
		this.blacklisted = false;
		this.roleFlag = 0; 
		this.takenTests = new ArrayList<TakenQuiz>();
	}


	public User(String firstName, String lastName, String username, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.avgScore = 0.0;
		this.approved = false;
		this.blacklisted = false;
		this.roleFlag = 0; 
		this.takenTests = new ArrayList<TakenQuiz>();
	}
	
	public User(String username, String password, String firstName, String lastName, String email, ArrayList<TakenQuiz> takenTests) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.avgScore = 0.0;
		this.approved = false;
		this.blacklisted = false;
		this.roleFlag = 0; 
		this.takenTests = takenTests;
	}
	
	public User(Integer userId, String firstName, String lastName, String email, String favColor, String username,
			String password, Double avgScore, List<TakenQuiz> takenTests, Boolean approved,
			Boolean blacklisted, Integer roleFlag) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.favColor = favColor;
		this.username = username;
		this.password = password;
		this.avgScore = avgScore;
		this.takenTests = takenTests;
		this.approved = approved;
		this.blacklisted = blacklisted;
		this.roleFlag = roleFlag;
	}
	
	//Constructor for explicitly giving user roles
	public User(String firstName, String lastName, String username, String email, String password, int roleFlag) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.avgScore = 0.0;
		this.approved = false;
		this.blacklisted = false;
		this.roleFlag = roleFlag; 
		this.takenTests = new ArrayList<TakenQuiz>();
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

	public Double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}

	public List<TakenQuiz> getTakenTests() {
		return takenTests;
	}

	public void addTakenTests(TakenQuiz takenTest) {
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

	public Integer getWriter() {
		return roleFlag; 
	}

	public void setWriter(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public Integer getRoleFlag() {
		return roleFlag;
	}


	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}


	public void setTakenTests(List<TakenQuiz> takenTests) {
		this.takenTests = takenTests;
	}

}
