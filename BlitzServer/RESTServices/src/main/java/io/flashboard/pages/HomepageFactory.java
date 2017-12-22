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
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement closeLoginModalBtn;
	
	@FindBy(xpath = "//a[@class='sign-up']")
	WebElement signUpNav;
	
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
	
	@FindBy(xpath = "//a[text()='Browse']")
	WebElement browseNav;
	
	@FindBy(xpath = "//a[text()='Search']")
	WebElement searchNav;
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeNav;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement logoNav; 
	
	@FindBy(xpath="//div[@class='modal-content']")
	WebElement loginModal;
	
	@FindBy(xpath="//div[@class='modal-fade']")
	WebElement modalFade; 
	
	//still requires: navbar elements, all from those elements' links
	
	WebDriverWait wait; 
	
	public HomepageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1); 
		
	}
	
	public void clickLoginNav() {

		wait.until(ExpectedConditions.elementToBeClickable(loginNav));
		loginNav.click(); 
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
	public void clickCloseLoginModalX() {
		wait.until(ExpectedConditions.visibilityOf(this.closeLoginModalX));
		closeLoginModalX.click(); 
	}
	public void clickCloseLoginModalBtn() {
		wait.until(ExpectedConditions.visibilityOf(this.closeLoginModalBtn));
		closeLoginModalBtn.click(); 
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
