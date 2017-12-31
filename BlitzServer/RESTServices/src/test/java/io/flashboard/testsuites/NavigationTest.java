package io.flashboard.testsuites;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.flashboard.pages.BrowseQuizTopicsPageFactory;
import io.flashboard.pages.BrowseQuizzesPageFactory;
import io.flashboard.pages.CreatePageFactory;
import io.flashboard.pages.HomepageFactory;
import io.flashboard.pages.LoginModalFactory;
import io.flashboard.pages.SearchPageFactory;

public class NavigationTest {
	WebDriver driver;
	String url = "http://localhost:4200";
	HomepageFactory hpf; 


	@Test(groups = {"smoke", "navigation"},
			enabled = true, priority = 1)
	public void navbarTest() {
		hpf.clickLogoNav();
		hpf.clickSearchNav();
		hpf.clickQuizNav();
		hpf.clickStudyNav();
		hpf.clickSignUpNav();
		hpf.clickLoginNav();
		LoginModalFactory lmf = new LoginModalFactory(driver); 
		lmf.clickCloseBtn();	  
	}

	@Test(groups = {"smoke","login"},
			enabled = true, priority = 2)
	public void loginModalOpenAndCloseTest() {
		hpf.clickLoginNav(); 
		LoginModalFactory lmf = new LoginModalFactory(driver); 
		lmf.clickCloseBtn();
	}

	@Test(groups = {"smoke","search"},
			enabled = true, priority = 2)
	public void searchPageTest() {
		hpf.clickSearchNav();
		SearchPageFactory spf = new SearchPageFactory(driver); 
		spf.enterSearchText("search text");
		spf.clickSearchBtn();
	}

	@Test(groups = {"smoke", "writer"},
			enabled = true, priority = 2)
	public void createPageSmokeTest() {
		hpf.clickCreateNav();
		CreatePageFactory cpf = new CreatePageFactory(driver); 
		cpf.clickShowAddQuestionBtn();
		cpf.clickBackBtn(driver);
		cpf.clickShowTestMenuBtn();
		cpf.clickBackBtn(driver);
	}

	@Test(groups = {"smoke", "study"},
			enabled = true, priority = 2)
	public void studyPageSmokeTest() { 
		hpf.clickStudyNav();
	}
	
	@Test(groups = {"smoke", "browse", "quiz"},
			enabled = true, priority = 2)
	public void browseQuizzesSmokeTest() {
		hpf.clickQuizNav();
		BrowseQuizTopicsPageFactory bqtpf = new BrowseQuizTopicsPageFactory(driver); 
		int numTopics = bqtpf.getNumberOfTopics(); 
		System.out.println("Number of Topics: " + numTopics);
		BrowseQuizzesPageFactory bqpf;
		for(int i = 0; i < numTopics; i++) {
			bqtpf = new BrowseQuizTopicsPageFactory(driver); 
			bqtpf.clickTopicByIndex(i);
			bqpf = new BrowseQuizzesPageFactory(driver); 
			bqpf.clickBackBtn();			
		}
			
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
		hpf = new HomepageFactory(driver); 
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
