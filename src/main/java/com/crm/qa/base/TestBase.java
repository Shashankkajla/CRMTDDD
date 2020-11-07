package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
 
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver; // available in sel. so creating variable
	public static WebEventListener eventListener;

	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Selenium Code\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	    catch(IOException e)
		{
	    	e.printStackTrace();
		}
	
	}

       // Initialization Method
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		
	   if(browsername.equals("chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver", "D:\\Driv\\chromedriver.exe");
		   driver = new ChromeDriver();
	   }
	/*   else if(browsername.equals("FF"))
	   {
		   System.setProperty("webdriver.gecko.driver", "D:\\Driv\\geckodriver.exe");
		   driver = new FirefoxDriver();
	   }
	   */
	
       e_driver = new EventFiringWebDriver(driver);
       // register listner to eventfiringWebdriver
       eventListener = new WebEventListener();
       // reg your WebEventListner with eventFiringListner
       e_driver.register(eventListener);
       driver = e_driver;
	   
	   
	       driver.manage().window().maximize();
	       driver.manage().deleteAllCookies();
	       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	       driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	       
	       driver.get(prop.getProperty("url"));
	   
	   
	}
	

}
