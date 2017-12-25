package io.flashboard.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.User;
import io.flashboard.util.HibernateUtil;

public class Driver2 {
	public static void main(String[] args) { 
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		User newUser = new User("jef", "jeff", "jeff", "jeff", "jeff");
		//SQLIntegrityConstraintViolationException
		try {
			tx = session.beginTransaction();
			session.save(newUser);
			tx.commit();
			System.out.println("User: '" + newUser.getUsername() + "' has been successfully created!");
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("User creation failed!");
			he.printStackTrace();
			
		} finally {
			session.close();
		}
	}
}
