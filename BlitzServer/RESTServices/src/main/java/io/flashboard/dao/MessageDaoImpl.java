package io.flashboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.users.Message;
import io.flashboard.util.HibernateUtil;

public class MessageDaoImpl implements MessageDao {
	
	@Override
	public boolean createMessage(String username, String content) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Boolean bool = false;
		Message message = new Message(username, content);
		
		try {
			tx = session.beginTransaction();
			session.save(message);
			tx.commit();
			bool = true;
			System.out.println("Message: '" + message.getMessageId() + "' has been successfully created!");
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Message creation failed!");
			he.printStackTrace();
			
		} finally {
			session.close();
		}
		return bool;
	}	
}
