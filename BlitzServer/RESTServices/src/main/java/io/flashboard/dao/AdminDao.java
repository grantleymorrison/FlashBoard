package io.flashboard.dao;

public interface AdminDao {
	
	//User
	public boolean approveUser(String username);
	public boolean promoteUserToWriter(String username); 	//{user.setWriter(true);}
	public boolean blacklistUserAccount(String username);	//{user.setBlacklist(true);}
	public boolean denyUserAccount(String username); 		//{user.setApproved(false);}
	public boolean deleteUserAccount(String username);
	public boolean restoreUserAccount(String username);
	
	//Test
	
	public boolean removeTestById(int testId);
	
	
	//Comment
	public boolean addCommentByTestId(String username, int testId, String comment);
	public boolean removeCommentById(int commentId);
}
