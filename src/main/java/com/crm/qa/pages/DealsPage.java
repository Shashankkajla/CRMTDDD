package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase
{

	//OR :
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(xpath="//input[@name='cs_extended']")
	WebElement extendedField;
	
	//Select class
	@FindBy(xpath="//select[@name='cs_type']")
	WebElement csSelectType;
	
	@FindBy(xpath="//select[@name='cs_source']")
	WebElement csSourceType;
	
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	//Actions
	public boolean verifydealsLabel()
	{
		return dealsLabel.isDisplayed();	
	}
	
   public void verifyTypes(String val1, String val2)
   {
	   Select select = new Select(csSelectType);
	   select.selectByVisibleText(val1);
	   Select select1 = new Select(csSourceType);
	   select1.selectByVisibleText(val2);
	   
   }
	
	
 }
