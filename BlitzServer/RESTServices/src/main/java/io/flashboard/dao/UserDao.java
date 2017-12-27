package io.flashboard.dao;

import java.util.List;

import io.flashboard.beans.quiz.QuizQuestion;
import io.flashboard.beans.quiz.TakenQuiz;
import io.flashboard.beans.users.User;

//TODO: Messaging, Forum posting, Commenting

public interface UserDao {
	
	//User
	public boolean createNewUser(String firstName, String lastName, String username,
			String email, String password);
	public User getUserById(int userId);
	public User getUserByUsername(String username);
	public boolean addTakenTest(String username, TakenQuiz test);	
	public int activateUserAccountByUsername(String username);
	public int lockUserAccountByUsername(String username); 
	public int verifyCredentals(String username, String password); 
	public boolean userExists(String username); 
	
}
