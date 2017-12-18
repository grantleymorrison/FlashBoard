package io.flashboard.dao;

public interface MessageDao {
	public void createMessage(int userId, int messageId, String content);
}
