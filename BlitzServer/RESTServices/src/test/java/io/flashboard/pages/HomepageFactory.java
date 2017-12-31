package io.flashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageFactory {

	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement logoNav; 
	
	@FindBy(className = "navbar-toggle")
	WebElement navbarToggle; 
	
	@FindBy(xpath = "//a[@routerlink='search']")
	WebElement searchNav;

	@FindBy(xpath =  "//a[@routerlink='create']")
	WebElement createNav;

	@FindBy(xpath =  "//a[@routerlink='browse']")
	WebElement browseQuizNav;

	@FindBy(xpath =  "//a[@routerlink='study']")
	WebElement studyNav;
	
	@FindBy(xpath = "//li[@class='login']")
	WebElement loginNav;

	@FindBy(xpath = "//a[@class='sign-up']")
	WebElement signUpNav;
	
	@FindBy(xpath = "//*[@id='myModal']")
	WebElement loginModal; 
	
	
	
	WebDriverWait wait; 
	
	public HomepageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2); 
		
	}

	public void clickLogoNav() {
		logoNav.click(); 
	}
	public void clickNavbarToggle() {
		navbarToggle.click(); 
		wait.until(ExpectedConditions.attributeContains(
			By.className("navbar-collapse"), "aria-expanded", "true"));
	}
	public void clickSearchNav() {
		searchNav.click(); 
	}
	public void clickCreateNav() {
		createNav.click(); 
	}
	public void clickQuizNav() {
		browseQuizNav.click(); 
	}
	public void clickStudyNav() {
		studyNav.click(); 
	}	
	public void clickLoginNav() {
		loginNav.click(); 
		wait.until(ExpectedConditions.visibilityOf(loginModal)); 
	}
	public void clickSignUpNav() {
		signUpNav.click();
	}
	

}
