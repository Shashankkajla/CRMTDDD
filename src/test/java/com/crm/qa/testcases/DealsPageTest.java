
package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage  homePage;
	TestUtil  testUtil;
	DealsPage dealsPage;
	String sheetName = "Deals";
  
	
  public DealsPageTest()
  {
	  super();
  }
	
	
  @BeforeMethod
  public void setUp()
  {
    initialization();
    loginPage = new LoginPage();
    homePage = new HomePage();
    testUtil= new TestUtil();
    dealsPage = new DealsPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.switchToFrame();
	dealsPage = homePage.verifyclickOnDealsLink();   
    
  }

 
  @Test(priority=1)
  public void verifydealsLabelTest()
  {
	  boolean flag = dealsPage.verifydealsLabel();
	  Assert.assertTrue(flag, "Tc Failed if Label isn't match");
  }
  
  
  @DataProvider
  public Object[][] getCRMTestData() throws InvalidFormatException 
  {
 	 Object data[][] = TestUtil.getTestData(sheetName);
 	 // Now this complete data is available on 2 D Array.
 	 return data;
 	 
  }
  
  @Test(priority=2, dataProvider="getCRMTestData")
  public void verifyTypesTest(String value1, String value2)
  {
	  dealsPage.verifyTypes(value1, value2);
  }
  
  
  
 @AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }
  
	
 }
