package io.flashboard.dao;

import java.util.List;

import io.flashboard.beans.CompletedComprehensionTest;
import io.flashboard.beans.ComprehensionTest;
import io.flashboard.beans.TestQuestion;
import io.flashboard.beans.User;

//TODO: Messaging, Forum posting, Commenting

public interface UserDao {
	
	//User
	public void createNewUser(String username, String password);
	public User selectUserById(int userId);
	public void addTakenTest(int userId, CompletedComprehensionTest test);
	public void addCommentByTestId(int userId, int testId, String comment);
	
	//Writer
	public void createComprehensionTest();
	public void createTrueFalseTestQuestion();
	public void createOneCorrectTestQuestion();
	public List<TestQuestion> selectTestsMadeByUserId(int userId);
	public void removeTestById(int userId, int testId);
	
}
