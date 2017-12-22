package io.flashboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.User;
import io.flashboard.util.HibernateUtil;

public class UserDaoImpl {
	
	public void createNewUser(String firstName, String lastName, String username, String email, String password) {
		Session session = null;
		Transaction tx = null;
		int userId = 0;
		
		User newUser = new User(firstName, lastName, username, email, password);
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			userId = (Integer)session.save(newUser);
			
			tx.commit();
		}
		catch(HibernateException he) {
			if(tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		}
		finally {
			//session.close();
		}
		
	}
}
