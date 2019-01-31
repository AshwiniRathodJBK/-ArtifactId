 package com.jbk;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class myBrowser {
	WebDriver driver;
	//ExtentHtmlReporter html;
	ExtentReports extent;
	ExtentTest test;
	
 @BeforeTest
 public void setUp()
 {
	 
	 ////generate html report
	ExtentHtmlReporter html=new ExtentHtmlReporter("Resource/Tracko.html");

	//initialize extentreports
	ExtentReports extent=new ExtentReports();
	
	//attach html report
	extent.attachReporter(html);
	
	
	//for creating our testcase
	ExtentTest test=extent.createTest("Tracko Regression");
	
	test.pass("Starting with Automation");
	System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
 driver= new ChromeDriver();
	
	test.pass("our browser get initiated");
	driver.get("https://www.facebook.com");
	
	test.pass("our url launched successfully");
	driver.manage().window().maximize();
	
	Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
	test.pass("We are in Login page");
	
	}
	
  @Test
  public void t()
  {
	  try{
	  test.pass("login page started");
	  FacebookLoginPage log=new FacebookLoginPage(driver, test);
	  log.LoginMethod();
	  test.pass("Login completed succesfully"); 
	  }
	  catch(Exception e)
	  {
	  test.fail("something went wrong with facebooklogin page");  
	  }
  }
 @AfterTest
 public void at() throws Exception
 {
	 driver.quit();
	 
	 test.pass("End of Execution");
	  extent.flush();
	 }

 }


