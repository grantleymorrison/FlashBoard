package io.flashboard.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTestPageFactory {
	
	@FindBy(name = "testTitle")
	WebElement testTitleText; 

	@FindBy(name = "testTopic")
	WebElement testTopicText; 

	@FindBy(name = "testDescription")
	WebElement testDescriptionText;

	@FindBy(id = "addQuestion")
	WebElement addQuestionBtn; 

	@FindBy(name = "hidecreatingcontentbtn")
	WebElement backBtn; 
	
	List<CreateQuestionPageFactory> questions;
	
	public CreateTestPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	
	
}
