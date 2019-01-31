package com.java;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jbk.FacebookLogin;

public class Log4jClass {

	static Logger logger = Logger.getLogger(Log4jClass.class);
	WebDriver driver;
	@BeforeTest
	public void method()
	{
		//BasicConfigurator.configure();// there is no use of such 
		
		PropertyConfigurator.configure("Resource/log4j.properties"); //this line gives output according to us and attach one propery file in it and on that basisi they generate reports means log files 
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		logger.info("starting with automation is chrome");
		 driver= new ChromeDriver();
			logger.info("chrome started");

		 driver.get("https://www.facebook.com");
			logger.info("opening site");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	@Test
	public void Login()
	{
		logger.info("login  method");
		FacebookLogin2 login=new FacebookLogin2(driver);
		login.FbLogin();
		logger.info("login method successful");
		
	}
	@AfterTest
	public void teardown()
	{    
		
		//logger.debug("DEBUG : End of execution");
		logger.info("INFO :End of execution");
		//logger.warn("INFO :End of execution");
		//logger.error("INFO :End of execution");

       driver.quit();
		
	}
	
}
