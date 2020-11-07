package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TasksPage tasksPage;
    TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
        loginPage = new LoginPage(); // Sothat i can access login class method.
        // Now i have to login into the application, So what i have to do ?
        //in this i am checking HomePage So to reach at homePage i have to login first
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        tasksPage = new TasksPage();
        dealsPage =new DealsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        // coz. this login method is returning homepage class obj. check on loginpage, or loginpageTest.
        
	}
	
	
    @Test(priority=1)
    public void verifyHomePageTitleTest()
    {
    	String homePagetitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePagetitle, "CRMPRO", " *** HomePage title not Matched *** ");
    }
	
    @Test(priority=2)
    public void verifyuserLabelTest()
    {
    	testUtil.switchToFrame();
    	boolean flag = homePage.verifyuserLabel();
    	Assert.assertTrue(flag);
    // It will Fail coz. frame in the application, So create 1 common method to switch to Frame in util Package.
    // All common method which is applicable for all classes comes under util class.
    
    }
    
	// Note : Tc's should be independent to each other.
    //Before each Testcase launch the browser & login.
    //after each Test case quit the browser.
	@Test(priority=3)
	public void verifyclickOnContactsLinkTest()
	{
	     testUtil.switchToFrame();
		contactsPage = homePage.verifyclickOnContactsLink();
		
	}
	
	@Test(priority=4)
	public void verifyclickOnDealsLinkTest()
	{
		testUtil.switchToFrame();
	  dealsPage = homePage.verifyclickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyclickOnTasksLinkTest()
	{
		testUtil.switchToFrame();
		tasksPage = homePage.verifyclickOnTasksLink();
	}
	
    
    
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
