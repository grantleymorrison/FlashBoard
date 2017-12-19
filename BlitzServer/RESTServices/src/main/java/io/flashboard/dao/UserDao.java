package io.flashboard.dao;

import io.flashboard.beans.User;

//TODO: Separate user roles into their own dao's?

public interface UserDao {
	
	//User
	public void createNewUser(String username, String password);
	
	//Writer
	public void createComprehensionTest();
	public void createTrueFalseTestQuestion();
	public void createOneCorrectTestQuestion();
	
	//Admin
	public void approveUser(String username);
	public void promoteUserToWriter(User user); 	//{user.setWriter(true);}
	public void approveUserAccount(User user); 	//{user.setApproved(true);}
	public void blacklistUserAccount(User user);	//{user.setBlacklist(true);}
	public void denyUserAccount(User user); 		//{user.setApproved(false);}
}
