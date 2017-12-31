package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageFactory {

	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement logoNav; 

	@FindBy(xpath = "//a[text()='Search']")
	WebElement searchNav;

	@FindBy(xpath = "")
	WebElement createNav;

	@FindBy(xpath = "")
	WebElement quizNav;

	@FindBy(xpath = "")
	WebElement studyNav;
	
	@FindBy(xpath = "//li[@class='login']")
	WebElement loginNav;

	@FindBy(xpath = "//li[text()=' Sign Up']")
	WebElement signUpNav;
	
	
	
	WebDriverWait wait; 
	
	public HomepageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1); 
		
	}

	public void clickLogoNav() {
		logoNav.click(); 
	}
	public void clickSearchNav() {
		searchNav.click(); 
	}
	public void clickCreateNav() {
		createNav.click(); 
	}
	public void clickQuizNav() {
		quizNav.click(); 
	}
	public void clickStudyNav() {
		studyNav.click(); 
	}	
	public void clickLoginNav() {
		wait.until(ExpectedConditions.elementToBeClickable(loginNav));
		loginNav.click(); 
	}
	public void clickSignUpNav() {
		signUpNav.click();
	}
	

}
