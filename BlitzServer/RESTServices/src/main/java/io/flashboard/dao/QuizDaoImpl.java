package io.flashboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;
import io.flashboard.util.HibernateUtil;

//TODO: Implement
	/* 	
	public int removeQuizByQuizId(int quizId); 
	public int removeQuizByTitle(String quizTitle); 
	public int addQuestionToQuizByQuizId(int quizId, QuizQuestion question);
	public int removeQuestionFromQuizByQuizId(int quizId, QuizQuestion question); 
	public int addQuestionToReserve(QuizQuestion question); 
	public int removeQuestionFromReseverById(int quizId); 
	
	public Quiz getQuizById(int quizId); 
	public Quiz getQuizByTitle(String quizTitle); 
	 */
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

	@Override
	public int removeQuizByQuizId(int quizId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeQuizByTitle(String quizTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addQuestionToQuizByQuizId(int quizId, QuizQuestion question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeQuestionFromQuizByQuizId(int quizId, QuizQuestion question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addQuestionToReserve(QuizQuestion question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeQuestionFromReseverById(int quizId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Quiz getQuizById(int quizId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quiz getQuizByTitle(String quizTitle) {
		// TODO Auto-generated method stub
		return null;
	}
}
