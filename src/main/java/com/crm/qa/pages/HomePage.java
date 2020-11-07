
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	// OBJECT REPOSITORIES : OR
	
	@FindBy(xpath="//td[contains(text(), 'User: Shashank Kajla')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	// To click on New Contacts link Mouse Over
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	// Initializing the OR'S
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyuserLabel()
	{
	   return userNameLabel.isDisplayed();	
	}
	
	public ContactsPage verifyclickOnContactsLink()
	{
		contactsLink.click();
	    return new ContactsPage();
	}
	
	public DealsPage verifyclickOnDealsLink()
	{
		dealsLink.click();
	    return new DealsPage();
	}
	
	public TasksPage verifyclickOnTasksLink()
	{
		tasksLink.click();
	    return new TasksPage();
	}
	
	// Mouse over : To go to New Contacts As its available on Home Page as well so creating method here, Using DataDriven to fill form
	public void clickOnNewContact() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(contactsLink).build().perform();
		//Thread.sleep(2000);
		 newContactLink.click();
		// Writing method inside contacts page to fill form.
	}
		
	// Note : If you are clicking to btn or link than the method will return next landing page obj. alwz.
	// These are called Page libraries : WebObject OR+ Action Methods.
	
  }
