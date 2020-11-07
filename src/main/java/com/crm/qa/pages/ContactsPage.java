package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase // TestBase WebDriver driver;
{

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;	
	
	// I want to click on check-box of dynamic webTable
	// not a good approach if i need to select another data in future from Web table
	/*@FindBy(xpath="//a[contains(text(),'Rohan Kaja')]/parent::td/preceding-sibling::td//input[@type='checkbox' and @name='contact_id']")
    WebElement checkBoxTable;	*/
	
	//Form Fill Page Factory
	@FindBy(xpath="//select[@name='title']")
	WebElement titleIs;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
   
	
	public ContactsPage()
	{
	PageFactory.initElements(driver, this); 
		// If i will not extend test base i won't initialize bobj. to my WebDriver coz weDriver declare in TestBase}
	}
	public boolean verifycontactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	// Creating method to check that particular check box.
	
	public void verifyselectContactsByName(String name)
	{                         // Replacing Rohan Kajla = name
	driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"
    + "/parent::td/preceding-sibling::td//input[@type='checkbox' and @name='contact_id']")).click();
	
	// i pass the name & user is able to select it whatever the name it will pass now
	}
	
	//NewContacts Page method to fill form
	
	public void createNewContact(String title, String ftname, String ltname, String comp)
	{
		Select sel = new Select(titleIs);
	     sel.selectByVisibleText(title);
	     
	     firstName.sendKeys(ftname);
	     lastName.sendKeys(ltname);
	     company.sendKeys(comp);
	     driver.findElement(By.xpath("//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")).click();
	     
	}
	
	
		
	
}
