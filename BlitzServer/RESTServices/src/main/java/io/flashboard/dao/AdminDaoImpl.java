package io.flashboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.users.User;
import io.flashboard.util.HibernateUtil;

//TODO: Implement
	/*
	 * restoreUserAccount
	 * 	restore blacklisted/banned users to full user status
	 * removeTestById
	 * addCommentByTestId
	 * removeCommentById
	 */

public class AdminDaoImpl implements AdminDao {
	
	public static UserDaoImpl udi = new UserDaoImpl();
	
	@Override
	public boolean approveUser(String username) {
		Boolean bool = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User myUser = udi.getUserByUsername(username);
		try {
			tx = session.beginTransaction();
			myUser.setApproved(true);
			session.update(myUser);
			tx.commit();
			bool = true;
			System.out.println("User: '" + username + "' successfully approved.");
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return bool;
	}
	
	@Override
	public boolean promoteUserToWriter(String username) {
		Boolean bool = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User myUser = udi.getUserByUsername(username);
		try {
			tx = session.beginTransaction();
			myUser.setRoleFlag(2);
			session.save(myUser);
			tx.commit();
			bool = true;
			System.out.println("User: '" + username + "' successfully approved.");
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return bool;
	}
	
	@Override
	public boolean blacklistUserAccount(String username) {
		Boolean bool = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User myUser = udi.getUserByUsername(username);
		try {
			tx = session.beginTransaction();
			myUser.setBlacklisted(true);
			session.save(myUser);
			tx.commit();
			bool = true;
			System.out.println("User: '" + username + "' successfully approved.");
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return bool;
	}
	
	@Override
	public boolean denyUserAccount(String username) {
		Boolean bool = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User myUser = udi.getUserByUsername(username);
		try {
			tx = session.beginTransaction();
			myUser.setBlacklisted(true);
			session.delete(myUser);
			tx.commit();
			bool = true;
			System.out.println("User: '" + username + "' successfully denied.");
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return bool;
	}
	
	@Override
	public boolean deleteUserAccount(String username) {
		Boolean bool = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User myUser = udi.getUserByUsername(username);
		try {
			tx = session.beginTransaction();
			myUser.setBlacklisted(true);
			session.delete(myUser);
			tx.commit();
			bool = true;
			System.out.println("User: '" + username + "' successfully deleted.");
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return bool;
	}
	
	@Override
	public boolean removeTestById(int testId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addCommentByTestId(String username, int testId, String comment) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean removeCommentById(int commentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean restoreUserAccount(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
