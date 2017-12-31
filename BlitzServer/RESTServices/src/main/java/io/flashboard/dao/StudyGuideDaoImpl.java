package io.flashboard.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import io.flashboard.beans.quiz.Comment;
import io.flashboard.beans.studyguide.CommentSG;
import io.flashboard.beans.studyguide.StudyGuide;
import io.flashboard.util.HibernateUtil;

public class StudyGuideDaoImpl implements StudyGuideDao {

	/**
	 * gets title, body, img url, and author and inserts guid into database
	 * 
	 * @param guide
	 *            information
	 * @return status of transaction
	 */
	@Override
	public boolean addStudyGuide(String title, String[] body, String imgUrl, String author) {

		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		ArrayList<String> arrListBody = new ArrayList<String>(Arrays.asList(body));
		LocalDateTime createdDate = LocalDateTime.now();
		
		try {
			StudyGuide newStudyGuide = new StudyGuide(title, arrListBody, imgUrl, author, null, null, createdDate);
			tx = session.beginTransaction();
			session.save(newStudyGuide);
			success = true;
			System.out.println(newStudyGuide);
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

	@Override
	public StudyGuide getStudyGuide(int guideId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Criteria criteria;
		StudyGuide studyGuide = null;
		try {
			criteria = session.createCriteria(StudyGuide.class);
			studyGuide = (StudyGuide) criteria.add(Restrictions.like("studyGuideId", guideId)).uniqueResult();

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return studyGuide;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudyGuide> getAllStudyGuides() {
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		Transaction tx = null;
		List<StudyGuide> guides = null;
		try {
			tx = session.beginTransaction();
			hql = "FROM io.flashboard.beans.studyguide.StudyGuide";
			query = session.createQuery(hql);
			guides = query.list();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return guides;
	}
	
	/**
	 * Gets the comments associated with a study guide
	 * 
	 * @param id for study guide
	 * 
	 * @return list of comments
	 * 
	 */
	@Override
	public List<CommentSG> getStudyGuideComments(int guideId) {
		List<CommentSG> comments = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		Query query = null;
		String hql = "FROM "
		
		try {
			query = session.createQuery(arg0)
		}
		
		return null;
	}
}
