package io.flashboard.dao;

public interface MessageDao {
	
	public boolean createMessage(String username, String content);
}
