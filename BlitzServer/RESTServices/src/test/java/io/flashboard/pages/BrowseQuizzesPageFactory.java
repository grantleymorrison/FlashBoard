package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowseQuizzesPageFactory {

	@FindBy(id = "back-btn")
	WebElement backBtn; 
	
	WebDriverWait wait; 
	public BrowseQuizzesPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2); 
	}
	
	public void clickBackBtn() {
		backBtn.click(); 
	}
	
	
}
