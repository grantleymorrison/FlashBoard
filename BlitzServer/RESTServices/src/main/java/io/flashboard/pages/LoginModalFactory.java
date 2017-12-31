package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginModalFactory {

	@FindBy(xpath = "//input[@name='username']")
	WebElement loginUsernameTxt; 

	@FindBy(xpath = "//input[@name='password']")
	WebElement loginPasswordTxt; 
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement logMeInBtn;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement closeLoginModalHeaderX;
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement closeLoginModalFooterBtn;
	
	@FindBy(xpath = "//a[text()='Forgot username']")
	WebElement forgotUsernameLink; 

	@FindBy(xpath = "//a[text()='Forgot password']")
	WebElement forgotPasswordLink; 
	
	
	WebDriverWait wait; 
	public LoginModalFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2); 
		
	}
	
	public void enterLoginUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(this.loginUsernameTxt));
		loginUsernameTxt.sendKeys(username);
	}	
	public void enterLoginPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(this.loginPasswordTxt));
		loginPasswordTxt.sendKeys(password);
	}
	public void clickLogMeIn() {
		wait.until(ExpectedConditions.visibilityOf(this.logMeInBtn));
		logMeInBtn.click(); 
	}	
	public void clickCloseX() {
		closeLoginModalHeaderX.click(); 
	}
	public void clickCloseBtn() {
		closeLoginModalFooterBtn.click(); 
	}
	public void clickForgotUsernameLink() {
		forgotUsernameLink.click(); 
	}
	public void clickForgotPasswordLink() {
		forgotPasswordLink.click(); 
	}



}
