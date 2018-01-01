package io.flashboard.services;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.flashboard.beans.users.User;
import io.flashboard.service.TokenService;

public class JavaTokenTest {
	private static User user;
	private static String token;
	
  @Test(priority = 1)
  public void createTokenTest() {
	  token = TokenService.create(user);
	  Assert.assertNotEquals(token, null);
  }
  
  @Test(priority = 2)
  public void parseTokenTest() {
	  boolean tokenResult = TokenService.verifyTestNG(token, user.getUsername());
	  Assert.assertEquals(tokenResult, true);
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
	  user = new User();
	  user.setUserId(1);
	  user.setUsername("jon_snow");
  }

  @AfterTest
  public void afterTest() {
  }

}
