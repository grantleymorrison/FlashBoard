package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageFactory {
	@FindBy(xpath = "//li[@class='login']")
	WebElement pollLoginNav;

	@FindBy(xpath = "//input[@name='username']")
	WebElement loginUsernameTxt; 

	@FindBy(xpath = "//input[@name='password']")
	WebElement loginPasswordTxt; 
	@FindBy(xpath = "")
	WebElement logMeInBtn;
	
	@FindBy(xpath = "")
	WebElement singUp;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement closeLoginModalX;
	
	@FindBy(xpath = "")
	WebElement closeLoginModalBtn;
	
	@FindBy(xpath = "")
	WebElement firstName;
	
	@FindBy(xpath = "")
	WebElement lastName; 
	
	@FindBy(xpath = "/html/body/app-root/div/app-signup/div/div/div[3]/input")
	WebElement desiredUsername;
	
	@FindBy(xpath = "/html/body/app-root/div/app-signup/div/div/div[4]/input")
	WebElement desiredPassword; 
	
	@FindBy(xpath = "")
	WebElement deisredPasswordReEnter;
	
	@FindBy(xpath = "")
	WebElement signUpEmail; 
	
	@FindBy(xpath = "")
	WebElement colorDropSelect; 
	
	@FindBy(xpath = "")
	WebElement createAccountButton;
	
	//still requires: navbar elements, all from those elements' links
	
	
	public HomepageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPollLogin() {
		pollLoginNav.click(); 
	}
	public void enterLoginUsername(String username) {
		loginUsernameTxt.sendKeys(username);
	}	
	public void enterLoginPassword(String password) {
		loginPasswordTxt.sendKeys(password);
	}
	public void clickLogMeIn() {
		
	}
	public void clickSignIn() {
		
	}
	public void clickCloseLoginModalX() {
		closeLoginModalX.click(); 
	}
	public void clickCloseLoginModalBtn() {
		closeLoginModalBtn.click(); 
	}
	
	public void clickCreateAccount() {
		
	}
	public void clickBrowse() {
		
	}

}
