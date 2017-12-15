package io.flashboard.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.flashboard.beans.Message;
import io.flashboard.util.HibernateUtil;

/**
 * Servlet implementation class LoadTest
 */
public class LoadTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Message testMessage = new Message(1,1,"This is a test message.");
			session.save(testMessage);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
