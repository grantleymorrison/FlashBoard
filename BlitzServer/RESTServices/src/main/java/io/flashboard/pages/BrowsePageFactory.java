package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowsePageFactory {
	
	@FindBy(xpath = "")
	WebElement browseNav; 
	
	
	
	
	private WebDriverWait wait;
	public BrowsePageFactory(WebDriver driver) {
		wait = new WebDriverWait(driver,1); 
		
	}

}
