package io.flashboard.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import io.flashboard.beans.studyguide.StudyGuide;
import io.flashboard.util.HibernateUtil;

public class StudyGuideDaoImpl implements StudyGuideDao {
	
	
	/**
	 * gets title, body, img url, and author and inserts 
	 * guid into database
	 * 
	 * @param guide information
	 * @return status of transaction
	 */
	@Override
	public boolean addStudyGuide(String title, String[] body, String imgUrl, String author) {
		
		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		ArrayList<String> arrListBody = new ArrayList<String>(Arrays.asList(body));
		LocalDateTime createdDate = LocalDateTime.now();
		StudyGuide newStudyGuide = new StudyGuide(title, arrListBody, imgUrl, author, createdDate);
		try {
			tx = session.beginTransaction();
			session.save(newStudyGuide);
			success = true;
			System.out.println(newStudyGuide);
			tx.commit();
		}catch(HibernateException he) {
			if(tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		}finally {
			session.close();
		}
		return success;
	}

	@Override
	public StudyGuide getStudyGuide(String title) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Criteria criteria;
		StudyGuide studyGuide = null;
		try {
			criteria = session.createCriteria(StudyGuide.class);
			studyGuide = (StudyGuide)criteria.add(Restrictions.like("title", title)).uniqueResult();
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			session.close();
		}
		return studyGuide;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudyGuide> getAllStudyGuides() {
		List<StudyGuide> guides = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			guides = session.createQuery("FROM Study_Guide").list();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return guides;
	}
}
