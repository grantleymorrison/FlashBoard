package io.flashboard.dao;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.flashboard.beans.users.User;

public class UserDaoTest {
	private static UserDaoImpl udi;
	
  @Test
  public void getUserByUsernameTest() {
	  User user = udi.getUserByUsername("han");
	  
	  Assert.assertEquals(user.getUsername(), "han");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  udi = new UserDaoImpl();
  }

  @AfterTest
  public void afterTest() {
  }

}
