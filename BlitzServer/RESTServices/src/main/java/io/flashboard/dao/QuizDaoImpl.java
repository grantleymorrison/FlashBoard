package io.flashboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.util.HibernateUtil;

public class QuizDaoImpl implements QuizDao {
	public int insertQuiz(Quiz quiz) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer quizId = null;
		
		try {
			// Attemps to add and get quiz Id back
			tx = session.beginTransaction();
			quizId = (Integer) session.save(quiz);
			System.out.println(quizId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				// Roll back IF transaction fails
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return quizId;
	}
}
