package io.flashboard.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import io.flashboard.beans.quiz.Comment;
import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;
import io.flashboard.util.HibernateUtil;

//TODO: Implement
	/* 	
	 * 
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
	public boolean addCommentByQuizId(int quizId, String username, String content) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Boolean success = false;
		Quiz quiz = new Quiz();
		Comment comment = new Comment(username, content);
		
		try {
			tx = session.beginTransaction();
			quiz = getQuizById(quizId);
			quiz.addComment(comment);
			session.save(quiz);
			System.out.println("Comment '" + comment.getCommentId() + "' successfully added to Quiz '" + quiz.getTestId() + "'.");
			success = true;
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			success = false;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}
	
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
		Session session = HibernateUtil.getSession();
		Criteria criteria;
		Quiz test = null;
		
		try {
			criteria = session.createCriteria(Quiz.class);
			//Adds like restriction to search for a particular username
			test = (Quiz)criteria.add(Restrictions.like("quizId", quizId)).uniqueResult();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			session.close();
		}
		return test;
	}

	@Override
	public Quiz getQuizByTitle(String quizTitle) {
		Session session = HibernateUtil.getSession();
		Criteria criteria;
		Quiz test = null;
		
		try {
			criteria = session.createCriteria(Quiz.class);
			//Adds like restriction to search for a particular username
			test = (Quiz)criteria.add(Restrictions.like("quizTitle", quizTitle)).uniqueResult();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			session.close();
		}
		return test;
	}
}
