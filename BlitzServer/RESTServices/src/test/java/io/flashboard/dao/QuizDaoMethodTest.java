package io.flashboard.dao;

import org.testng.annotations.Test;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.util.HibernateUtil;

import org.testng.annotations.BeforeMethod;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class QuizDaoMethodTest {
  @Test
  public void f() {
	  int quizId = 1050;
	  Session session = HibernateUtil.getSession();
	  Criteria criteria;
	  Quiz quiz = null;
	  criteria = session.createCriteria(Quiz.class);
	  quiz = (Quiz)criteria.add(Restrictions.like("quizId", quizId));
	  System.out.println(quiz);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Initiating QuizDaoMethodTest");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("All QuizDaoMethodTest finished running");
  }

}
