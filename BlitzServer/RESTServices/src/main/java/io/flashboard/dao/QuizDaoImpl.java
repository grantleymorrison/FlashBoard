package io.flashboard.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.quiz.Comment;
import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;
import io.flashboard.util.HibernateUtil;

//TODO: Implement
/*
public int addQuestionToQuizByQuizId(int quizId, QuizQuestion question);
public int removeQuestionFromQuizByQuizId(int quizId, QuizQuestion question); 
public int addQuestionToReserve(QuizQuestion question); 
public int removeQuestionFromReseverById(int quizId); 
 */
public class QuizDaoImpl implements QuizDao {
	@Override
	public boolean createQuizMinArgs(String quizTitle, String topic, String description) {
		Quiz newQuiz = new Quiz(quizTitle, topic, description);
		Boolean success = false;
		if (insertQuiz(newQuiz) == true) {
			success = true;
		}
		return success;
	}
	
	@Override
	public boolean createQuiz(String quizTitle, String topic, String description,
			Set<QuizQuestion> questions, String creatorId, int maxScore) {
		Quiz newQuiz = new Quiz(quizTitle, topic, description, questions, creatorId,
				maxScore);
		Boolean success = false;
		if (insertQuiz(newQuiz) == true) {
			success = true;
		}
		return success;
	}
	
	public boolean addCommentByQuizId(int quizId, String username, String content) {
		Boolean success = false;
		Quiz test = new Quiz();
		Comment comment = new Comment(username, content);
		test = getQuizById(quizId);
		test.getComments().add(comment);
		System.out.println(test.getClass().getName());
		System.out.println(test.toString());
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(test);
			tx.commit();
			success = true;
			System.out.println("Comment '" + comment.getCommentId()
			+ "' successfully added to Quiz '" + test.getTestId() + "'.");
		} catch (HibernateException e) {
			if (tx != null) {
				// Roll back IF transaction fails
				tx.rollback();
			}
			success = false;
			System.err.println(
					"Quiz '" + test.getTestTitle() + "' was not succesfully updated.");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}
	
	public boolean insertQuiz(Quiz quiz) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Boolean success = null;
		
		try {
			tx = session.beginTransaction();
			session.save(quiz);
			tx.commit();
			success = true;
		} catch (HibernateException e) {
			if (tx != null) {
				// Roll back IF transaction fails
				tx.rollback();
			}
			success = false;
			System.out.println(
					"Quiz '" + quiz.getTestTitle() + "' was not succesfully inserted.");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}
	
	@Override
	public boolean removeQuizByQuizId(int quizId) {
		Quiz currQuiz = getQuizById(quizId);
		Session session = HibernateUtil.getSession();
		Boolean success = false;
		try {
			session.delete(currQuiz);
			session.flush();
			if (getQuizById(quizId) == null) {
				success = true;
			}
		} catch (HibernateException he) {
			System.out.println("Quiz '" + quizId + "' unsuccessfully deleted.");
			he.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}
	
	@Override
	public boolean removeQuizByTitle(String quizTitle) {
		Quiz currQuiz = getQuizByTitle(quizTitle);
		Session session = HibernateUtil.getSession();
		Boolean success = false;
		try {
			session.delete(currQuiz);
			session.flush();
			if (getQuizByTitle(quizTitle) == null) {
				success = true;
			}
		} catch (HibernateException he) {
			System.out.println("Quiz '" + quizTitle + "' unsuccessfully deleted.");
			he.printStackTrace();
		} finally {
			session.close();
		}
		return success;
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
	
	public List<Quiz> getAllQuizzes() {
		Session session = HibernateUtil.getSession();
		Query query;
		List<Quiz> q = new ArrayList<Quiz>();
		try {
			query = session.createQuery("from Quiz q");
			query.executeUpdate();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return q;
	}
	
	public static void getQuiz() {
		Session session = HibernateUtil.getSession();
		Query query = null;
		String hql = "FROM Quiz";
		
		try {
			query = session.createQuery(hql);
			System.out.println(query.list());
			
		} catch (HibernateException he) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Quiz getQuizById(int quizId) {
		Session session = HibernateUtil.getSession();
		Quiz test = new Quiz();
		String sql = "SELECT QUIZ_ID, QUIZ_TITLE, QUIZ_SUBJECT, QUIZ_DESC, CREATOR_ID, CREATED_ON, MAX_SCORE FROM Quiz q where q.quiz_Id = :quiz";
		
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.setParameter("quiz", quizId);
			List<Object> result = (List<Object>) query.list();
			Iterator<Object> itr = result.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				test.setTestId(Integer.parseInt(String.valueOf(obj[0])));
				test.setTestTitle(String.valueOf(obj[1]));
				test.setTopic(String.valueOf(obj[2]));
				test.setDescription(String.valueOf(obj[3]));
				test.setCreatorId(String.valueOf(obj[4]));
				// test.setCreatedOn((LocalDateTime) (obj[5]));
				test.setMaxScore(Integer.parseInt(String.valueOf(obj[6])));
				break;
			}
			// test = (Quiz) query.uniqueResult();
			// test = (Quiz)criteria.add(Restrictions.like("quizId",
			// quizId)).uniqueResult();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return (Quiz) test;
	}
	
	@Override
	public Quiz getQuizByTitle(String quizTitle) {
		Session session = HibernateUtil.getSession();
		// Criteria criteria;
		Query query;
		Quiz test = null;
		
		try {
			// criteria = session.createCriteria(Quiz.class);
			// Adds like restriction to search for a particular quizTitle
			// System.out.println(criteria.list().toString());
			// test = (Quiz)criteria.add(Restrictions.like("quizTitle",
			// quizTitle)).uniqueResult();
			query = session.createQuery("from Quiz q where q.quizTitle = :tquiz");
			test = (Quiz) query.setString("tquiz", quizTitle).uniqueResult();
			test.toString();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return test;
	}
}
