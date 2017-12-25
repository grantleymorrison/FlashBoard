package io.flashboard.dao;

import java.util.List;

import io.flashboard.beans.CompletedComprehensionTest;
import io.flashboard.beans.TestQuestion;
import io.flashboard.beans.User;

//TODO: Messaging, Forum posting, Commenting

public interface UserDao {
	
	//User
	public boolean createNewUser(String firstName, String lastName, String username,
			String email, String password);
	public User selectUserById(int userId);
	public User selectUserByUsername(String username);
	public boolean addTakenTest(String username, CompletedComprehensionTest test);	
}
