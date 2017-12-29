package io.flashboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import io.flashboard.beans.quiz.TakenQuiz;
import io.flashboard.beans.users.User;
import io.flashboard.util.HibernateUtil;

//TODO: Implement
	/* verifyCredentials
	 * userExists
	 */

public class UserDaoImpl implements UserDao{
	

	@Override
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
		return bool;
	}
	
	/**
	 * Gets a unique user from the database, if he/she exists
	 * Utilizes Criterias
	 * 
	 * @param username username to be searched for
	 * @return the user if he/she exists, otherwise null
	 */
	@Override
	public User getUserByUsername(String username) {
		Session session = HibernateUtil.getSession();
		Criteria criteria;
		User user = null;
		
		try {
			criteria = session.createCriteria(User.class);
			//Adds like restriction to search for a particular username
			user = (User)criteria.add(Restrictions.like("username", username)).uniqueResult();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
	
	public List<String> getAllUsers(){
		Session session = HibernateUtil.getSession();
		List<String> newUsers = new ArrayList<>();
		
		Criteria criteria;
		
		try {
			criteria = session.createCriteria(User.class);
			newUsers = criteria.add(Restrictions.like("approved", false)).setProjection(Projections.property("username")).list();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			session.close();
		}
		
		if(newUsers.isEmpty()) {
			newUsers = null; 
		}
		
		return newUsers;
	}
	
	@Override
	public boolean addTakenTest(String username, TakenQuiz test) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User currUser = getUserByUsername(username);
		List<TakenQuiz> newList;
		newList = currUser.getTakenTests();
		newList.add(test);
		currUser.setTakenTests(newList);
		session.save(currUser);
		tx.commit();
		return true;
	}

	@Override
	public int verifyCredentals(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}
}
