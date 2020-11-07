package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
     LoginPage loginPage;
     HomePage homePage;
     ContactsPage contactsPage;
     TestUtil testUtil;
     //Excel Sheet Name
     String sheetName = "Contacts";
     
 public ContactsPageTest()
 {
	 super();
 }

 
 @BeforeMethod
 public void setUp()
 {
	 initialization();
	 testUtil = new TestUtil();
	 contactsPage = new ContactsPage();
	 loginPage= new LoginPage();
	 homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 testUtil.switchToFrame();
	 contactsPage = homePage.verifyclickOnContactsLink();
 
 }
 
 
 @Test(priority=1)
 public void verifycontactsLabelTest()
 {
	boolean flag = contactsPage.verifycontactsLabel();
	Assert.assertTrue(flag);
	
 }
 
 @Test(priority=2)
 public void verifyselectContactsByNameTest()
 {   
	 contactsPage.verifyselectContactsByName("Mohan Sohan");

 }
 
 @Test(priority=3) // if both Test case priority is same than TestNg decides which one executes first.
 public void verifyselectMultipleContactsTest()
 {   
	 contactsPage.verifyselectContactsByName("Mohan Sohan");
	 contactsPage.verifyselectContactsByName("Rohan Kajla");

 }
 
 
 @DataProvider
 public Object[][] getCRMTestData() throws InvalidFormatException 
 {
	 Object data[][] = TestUtil.getTestData(sheetName);
	 // Now this complete data is available on 2 D Array.
	 return data;
	 
 }
 
 @Test(priority=4, dataProvider="getCRMTestData")
 public void createNewContactTest(String title, String firstname, String lastname, String company) throws InterruptedException 
 // give data provider Column name, whenever fetching data from excel sheet, either give colmn mismatch error.
 {
	  homePage.clickOnNewContact();
	  Thread.sleep(4000);
	 //contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google"); now no need for Hardcoded value.
	  contactsPage.createNewContact(title, firstname, lastname, company);
	  // driver .click(). --> contacts 
	  // than use Assertion that data is added or not
 }
 
 
 @AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }
 
  
  }
