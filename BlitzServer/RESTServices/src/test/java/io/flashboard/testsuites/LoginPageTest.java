package io.flashboard.testsuites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.flashboard.pages.HomepageFactory;

public class LoginPageTest {
	
	WebDriver driver;
	String url = "http://localhost:4200";
	
	
  @Test(groups = {"smoke","login"},
		  enabled = true, priority = 1)
  public void loginModalSmoke() {
	  HomepageFactory hpf = new HomepageFactory(driver); 
	  WebDriverWait wait = new WebDriverWait(driver, 1); 
	  hpf.clickLoginNav();
	  hpf.clickCloseLoginModalBtn();
	  hpf.clickLoginNav();
	  hpf.enterLoginUsername("username");
	  hpf.enterLoginPassword("password");
	  hpf.clickCloseLoginModalBtn();
  }
  
  @Test(groups = {"login", "happy"}, dependsOnMethods = "loginModalSmoke",
		  enabled = true, priority = 2)
  public void loginValidTest(){
	  HomepageFactory hpf = new HomepageFactory(driver); 
	  WebDriverWait wait = new WebDriverWait(driver, 1); 
	  hpf.clickLoginNav();
	  hpf.enterLoginUsername("username");
	  hpf.enterLoginPassword("password");
	  hpf.clickLogMeIn();
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
	  System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	  driver = new ChromeDriver(); 
	  driver.get(url);
  }

  @AfterTest
  public void afterTest() {
	  if(driver != null) 
		  driver.quit(); 
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
