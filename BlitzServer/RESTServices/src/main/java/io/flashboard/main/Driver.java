package io.flashboard.main;


import io.flashboard.dao.UserDaoImpl;
public class Driver {
	public static void main(String[] args) {
		/*
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
		*/
		UserDaoImpl udi = new UserDaoImpl();
		udi.createNewUser("James", "Jones", "jamesjones", "james.jones@mail.com", "thequickbrownfox");
	}
}
