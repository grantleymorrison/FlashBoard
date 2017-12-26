package io.flashboard.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.ComprehensionTest;
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
			TestQuestion tq = new TestQuestion();
//					"Math", "Pick the number with the largest prime integer factor:", "15",
//					"4", "9", "12", "15's factors are 3 and 5, both of which are primes. 12 has 6 as a factor, but 6 is not prime.", 5); 
			session.save(tq); 
			TestQuestion tqt = (TestQuestion)session.get(TestQuestion.class, tq.getQuestionId()); 
			System.out.println(tqt.toString());
			tx.commit(); 
			
			tx = session.beginTransaction();
			ComprehensionTest ct = new ComprehensionTest("Sample Test", "Math", "An example of a simple test"); 
			ct.addQuestion(tq);
			ct.setCreatorId("wilford");
			System.out.println("BEFORE INSERT");
			System.out.println();
			session.save(ct);
			tx.commit(); 
			
			tx = session.beginTransaction();
			ComprehensionTest ct2 = (ComprehensionTest)session.get(ComprehensionTest.class, ct.getTestId());
			System.out.println("AFTER RETRIEVAL");
			System.out.println(ct2);
			tx.commit();
			
			tx = session.beginTransaction();
			
			
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
