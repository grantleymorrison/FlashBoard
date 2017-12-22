package io.flashboard.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.User;
import io.flashboard.util.HibernateUtil;

public class UserDaoImpl {
	
	public boolean createNewUser(String firstName, String lastName, String username,
			String email, String password) {
		Boolean bool = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		User newUser = new User(firstName, lastName, username, email, password);
		
		try {
			tx = session.beginTransaction();
			session.save(newUser);
			tx.commit();
			bool = true;
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
			
		} finally {
			session.close();
		}
		return bool;
	}
	
	public User selectUserByUsername(String username) {
		Session session = HibernateUtil.getSession();
		String hql = "FROM USERS U WHERE U.USERNAME = " + username;
		User newUser = null;
		try {
			Query query = session.createQuery(hql);
			newUser = (User)query.uniqueResult();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return newUser;
	}
}
