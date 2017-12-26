package io.flashboard.dao;

public interface MessageDao {
	public boolean createMessage(int userId, String content);
}
