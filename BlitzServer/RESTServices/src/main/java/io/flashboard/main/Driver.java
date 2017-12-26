package io.flashboard.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.flashboard.beans.quiz.Comment;
import io.flashboard.beans.quiz.Question;
import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.Rating;
import io.flashboard.dao.QuizDao;
import io.flashboard.dao.QuizDaoImpl;

public class Driver {
	public static void main(String[] args) {
		/*
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {			
			tx = session.beginTransaction();
			TestQuestion tq = new TestQuestion("Math", "Pick the number with the largest prime integer factor:", "15",
					"4", "9", "12", "15's factors are 3 and 5, both of which are primes. 12 has 6 as a factor, but 6 is not prime.", 5); 
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
		*/
		
//		UserDaoImpl udi = new UserDaoImpl();
//		udi.createNewUser("James", "Jones", "jamesjones", "james.jones@mail.com", "thequickbrownfox");
//		
//		User testUser = udi.selectUserByUsername("jamesjones");
//		
//		MessageDaoImpl mdi = new MessageDaoImpl();
//		mdi.createMessage(testUser.getUserId(), "This is a comment message");
		
		QuizDao qd = new QuizDaoImpl();
		List<Question> questions = new ArrayList<>();
		List<Comment> comments = new ArrayList<>();
		String[] awsq1 = {"Amazon Web Service", "Amazing Web Service", "Alluring Web Service", "Apple Web Service"};
		questions.add(new Question("What Does AWS stand for?", 51, awsq1, "Amazon Web Service", 50, new Rating(), comments));
	
		Quiz quiz1 = new Quiz("quiz 1 title", "AWS", "On RDS", "quizMaster", LocalDate.now(), 10, 0, questions,
				comments);
		Quiz quiz2 = new Quiz("quiz 2 title", "AWS", "On VPC", "quizMaster", LocalDate.now(), 10, 0, questions,
				comments);
		
		// Insertions
		System.out.println("Quiz 1 inserted with quiz id: " + qd.insertQuiz(quiz1));
		System.out.println("Quiz 2 inserted with quiz id: " + qd.insertQuiz(quiz2));
	}
}