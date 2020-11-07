package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase
{
 // OR:
	@FindBy(xpath="//input[@name='cs_keyword']")
	WebElement keywordField;
	
	@FindBy(xpath="//input[@name='cs_extended']")
	WebElement extendedField;
	
	@FindBy(xpath="//td[contains(text(),'Tasks')]")
	WebElement tasksLabel;
	
	
	// Initialization
    public TasksPage()
	{
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean verifytasksLabel()
	{
		return tasksLabel.isDisplayed();
	}
	public void verifyFields(String keyfield, String extendfield)
	{
		keywordField.sendKeys(keyfield);
		extendedField.sendKeys(extendfield);
	}
		
	
  }
