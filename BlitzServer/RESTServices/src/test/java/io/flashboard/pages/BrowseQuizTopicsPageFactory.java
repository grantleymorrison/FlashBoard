package io.flashboard.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowseQuizTopicsPageFactory {

	List<WebElement> topics;
//	private static boolean debug = true; 
	
	WebDriverWait wait;
	public BrowseQuizTopicsPageFactory(WebDriver driver) {
		topics = driver.findElements(By.xpath("//ul[@class='topics']/*"));
		wait = new WebDriverWait(driver, 2); 
	}

	public void clickTopicByIndex(int index) {
		topics.get(index).click(); 
		wait.until(ExpectedConditions.stalenessOf(topics.get(index)));
	}
	
	public int getNumberOfTopics() {
		return topics.size(); 
	}
	public void clickTopicByName(String topicName) {
		
	}
	
	
	
}
