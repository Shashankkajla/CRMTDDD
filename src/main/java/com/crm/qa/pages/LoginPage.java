package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// PAGE OBJECT REPOSITORY : OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password; 
	// Take screenshot disturb xpath to check, give time and event in console working so making correct xpath
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn; 
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmLogo;
		
	// Constructor to define Page Factory, to initialize page obj. we have 1 method is PageFactory.initElements(driver, proxy)
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this); // current class obj.
	}
	
	// Actions:
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) //shashankk , test123 will be given to un & pwd
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
	     loginBtn.click();
	     return new HomePage();
	}
	
	
	
}
