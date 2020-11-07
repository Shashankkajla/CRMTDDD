package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TasksPage taskspage;
	String sheetName= "Tasks";
	
	public TasksPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage= new HomePage();
		testUtil= new TestUtil();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        taskspage = homePage.verifyclickOnTasksLink();	
	}
	
	@Test(priority=1)
	public void verifyverifytasksLabelTest()
	{
		boolean flag = taskspage.verifytasksLabel();
		Assert.assertTrue(flag, "If not Tc's has failed page title doesn't Recorgnize");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException 
	 {
		 Object data[][] = TestUtil.getTestData(sheetName);
		 // Now this complete data is available on 2 D Array.
		 return data;	 
	 }
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void verifyFieldsTest(String keyword_field, String extended_field)
	{
		// taskspage.verifyFields("Rahul", "Mohan");
		 taskspage.verifyFields(keyword_field, extended_field);
	}
			
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
