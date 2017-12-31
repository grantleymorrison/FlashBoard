package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageFactory {

	@FindBy(xpath = "//*[@id='firstNameText']")
	WebElement firstNameText;
	@FindBy(xpath = "//*[@id='lastNameText']")
	WebElement lastNameText;
	@FindBy(xpath = "//*[@id='usernameText']")
	WebElement usernameText;
	@FindBy(xpath = "//*[@id='passwordText']")
	WebElement passwordText;
	@FindBy(xpath = "//*[@id='rePasswordText']")
	WebElement rePasswordText;
	@FindBy(xpath = "//*[@id='emailText']")
	WebElement emailText;
	@FindBy(xpath = "//*[@id='favColorSelect']")
	WebElement colorSelect;
	@FindBy(xpath = "//*[@id='createAcctBtn']")
	WebElement createAccountBtn; 
	
	
	WebDriverWait wait; 
	public RegistrationPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2);
	}
	
	public void enterFirstName(String fname) {
		firstNameText.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastNameText.sendKeys(lname);
	}
	public void enterUsername(String username) {
		usernameText.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordText.sendKeys(password);
	}
	public void reEnterPassword(String rePassword) {
		rePasswordText.sendKeys(rePassword); 
	}
	public void enterEmail(String email) {
		emailText.sendKeys(email);
	}
	public void clickColorSelect() {
		colorSelect.click(); 
	}
	public void clickCreateAccount() {
		createAccountBtn.click(); 
	}
	
	
	
}
