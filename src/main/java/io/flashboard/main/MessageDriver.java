package io.flashboard.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.Message;
import io.flashboard.util.HibernateUtil;

public class MessageDriver {
	public static void main(String[] args) {
		/*
		 * The below is to be abstracted into the Dao as createMessage(int userId, int messageId, String message)
		 * Optional: Keep track of users who've made a message
		 */
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Message testMessage = new Message(1,1,"This is a test message.");
			session.save(testMessage);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
