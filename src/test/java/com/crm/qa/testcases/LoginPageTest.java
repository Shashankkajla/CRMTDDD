
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.JiraPolicy;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
    HomePage homePage;
    Logger log = Logger.getLogger(LoginPageTest.class);
    // Import it Logger from TestNG, inside Logger class method present getLogger(pass class name here)
    
  //What is log? : capturing info/activities at the time of program execution. 
  	// types of logs:
  		//1. info
  		//2. warn
  		//3. debug
  		//4. fatal
  		
  	//how to generate the logs? : use Apache log4j API (log4j jar)
  	//How it works? : it reads log 4j configuration from log4j.properties file
  	//where to create: create inside resources folder
    
    
    // Comment WebFire Event to check logs on console 
    

	public LoginPageTest()
	{
		super(); // calling TestBase Constructor
	}

	@BeforeMethod
	public void setUp()
	{
		log.info("***********starting Browser********");
		initialization();
		loginPage = new LoginPage();	
	}
	
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=1) // (retryAnalyzer=com.analyzer.RetryAnalyzer.class)   
	// Class levels (retryAnalyzer=com.analyzer.RetryAnalyzer.class)
// Tomorrow 100 Tc's and you want to provide logic for 100 Tc's So its not good approach you want to add this line again & again.
// So, We have another interface calls RetryAnnotationTransformer, TransForm method is available in that particular interface.
	public void TitleTest()
	{   		log.info("***********validating Title********");
        String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO -  CRM software for customer relationship management, sales, and support.");
       // CRMPRO - CRM software for customer relationship management, sales, and support.
		log.info("***********Title Validated********");

		
	}
	@JiraPolicy(logTicketReady=true)
	@Test(priority=2)
	public void CrmLogoImageTest()
	{
		log.warn("********Hey check for image********");
		boolean flag= loginPage.validateCRMImage();
	    Assert.assertTrue(flag);
	    log.error("**********Hey fail it show error message if image not present******");
	}
	
	@Test(priority=3, enabled = true)
	public void loginTest()
	{
	  homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	       
	
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("******closing Browser************");
	}
}
