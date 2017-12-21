package io.flashboard.dao;

import io.flashboard.beans.User;

public interface AdminDao {
	//Admin
	public void createNewAdmin(String username, String password);
	public User selectAdminById(int adminId);
	
	//User
	public void approveUser(String username);
	public void promoteUserToWriter(int userId); 	//{user.setWriter(true);}
	public void approveUserAccount(int userId); 	//{user.setApproved(true);}
	public void blacklistUserAccount(int userId);	//{user.setBlacklist(true);}
	public void denyUserAccount(int userId); 		//{user.setApproved(false);}
	public void deleteUserAccount(int userId);
	
	//Test
	public void removeTestById(int testId);
	
	
	//Comment
	public void addCommentByTestId(int userId, int testId, String comment);
	public void removeCommentById(int commentId);
}
