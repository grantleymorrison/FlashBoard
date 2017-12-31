package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageFactory {
	@FindBy(xpath = "//li[@class='login']")
	WebElement loginNav;

	@FindBy(xpath = "//li[text()=' Sign Up']")
	WebElement signUpNav;

	@FindBy(xpath = "//a[text()='Browse']")
	WebElement browseNav;
	
	@FindBy(xpath = "//a[text()='Search']")
	WebElement searchNav;
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeNav;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement logoNav; 
	
	
	WebDriverWait wait; 
	
	public HomepageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1); 
		
	}
	
	public void clickLoginNav() {
		wait.until(ExpectedConditions.elementToBeClickable(loginNav));
		loginNav.click(); 
	}
	public void clickSignUpNav() {
		signUpNav.click();
	}
	public void clickBrowseNav() {
		browseNav.click();
	}
	public void clickSearchNav() {
		searchNav.click(); 
	}
	public void clickHomeNav() {
		homeNav.click(); 
	}
	public void clickLogoNav() {
		logoNav.click(); 
	}
	
	

}
