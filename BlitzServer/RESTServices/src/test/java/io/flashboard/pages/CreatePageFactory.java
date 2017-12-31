package io.flashboard.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePageFactory {
	
	@FindBy(name = "showTestMenuBtn")
	WebElement showTestMenuBtn; 
	
	@FindBy(name = "showAddQuestionBtn")
	WebElement showAddQuestionBtn; 
	
	@FindBy(name = "hidecreatingcontentbtn")
	WebElement hideCreateContentBtn; 
	
	WebDriverWait wait; 
	public CreatePageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2); 
		
	}
	
	public void clickShowTestMenuBtn() {
		showTestMenuBtn.click(); 
	}
	public void clickShowAddQuestionBtn() {
		showAddQuestionBtn.click(); 
	}
	public void clickBackBtn(WebDriver driver) {
		try {
			driver.findElement(By.name("hidecreatingcontentbtn")).click();
		}
		catch(NoSuchElementException e) {
			System.out.println("Back button not visible");
			return; 
		}
	}
	
	
	

}
