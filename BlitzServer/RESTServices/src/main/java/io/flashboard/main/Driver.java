package io.flashboard.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.Message;
import io.flashboard.beans.TestQuestion;
import io.flashboard.beans.User;
import io.flashboard.util.HibernateUtil;

import io.flashboard.dao.UserDaoImpl;
public class Driver {
	public static void main(String[] args) {
		/*
		 * The below is to be abstracted into the Dao as createMessage(int userId, int messageId, String message)
		 * Optional: Keep track of users who've made a message
		 */
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			User testUser = new User("Wilford", "Wilson","wilford", "wilfordson@gmail.com", "passwordw"); 
			session.save(testUser); 	
			tx.commit(); 
			tx = session.beginTransaction();

			Message testMessage = new Message(testUser.getUserId(), "This is a comment message");
			session.save(testMessage);
			tx.commit(); 
			tx = session.beginTransaction();
			TestQuestion tq = new TestQuestion("Pick the number with the largest prime integer factor:", "15",
					"4", "9", "12", "15's factors are 3 and 5, both of which are primes. 12 has 6 as a factor, but 6 is not prime.", 5); 
			session.save(tq); 
			TestQuestion tqt = (TestQuestion)session.get(TestQuestion.class, tq.getQuestionId()); 
			System.out.println(tqt.toString());
			
			
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		UserDaoImpl udi = new UserDaoImpl();
		udi.createNewUser("James", "Jones", "jamesjones", "james.jones@mail.com", "thequickbrownfox");
	}
}
