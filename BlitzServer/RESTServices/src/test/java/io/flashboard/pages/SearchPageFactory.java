package io.flashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageFactory {
	@FindBy(xpath = "//input[@value='Search here']")
	WebElement searchText; 
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchBtn; 
	
	
	
	
	WebDriverWait wait; 
	public SearchPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2); 
	}
	
	public void enterSearchText(String search) {
		searchText.sendKeys(search);
	}
	public void clickSearchBtn() {
		searchBtn.click(); 
	}
	
	
	
}
