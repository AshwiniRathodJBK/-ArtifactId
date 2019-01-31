package com.jbk;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyClass {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	
	
@BeforeTest
public void setUp()
{
	
	//initilize this class for creating blank html report
	ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("test.html");
	//we van see previous and current report
	htmlReporter.setAppendExisting(true);
	htmlReporter.config().setChartVisibilityOnOpen(true);
	htmlReporter.config().setDocumentTitle("Ashwini - ExtentReports");
	htmlReporter.config().setTheme(Theme.DARK);
	//initialize extentreport
	extent=new ExtentReports();
	
	//attach html report with this report
	extent.attachReporter(htmlReporter);
	
	//we have taken this class and try to start extent report
	test=extent.createTest("facebook-Regression");
	test.assignCategory("Regression");
	test.assignAuthor("Ashwini Rathod");
	
	//whatever we have required in report below data
	test.pass("start with automation");
	
	System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	driver= new ChromeDriver();

	//test.pass("our browser get initiated");
	test.log(Status.PASS,"our browser get initiated");
	
	driver.get("https://www.facebook.com");
	
	//screenshot
	CommonMethod ref=new CommonMethod(driver);
	try {
		test.info("I am in setup method").addScreenCaptureFromPath(ref.screenshot("screenshot5.png"));
	} catch(IOException e) {
	
	 test.fail("can not take screenshot");
	}
	test.pass("url launched");
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);// for waiting to load all things properly
	
	Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
    test.pass("we are in login page");
}
	
@Test
public void login()
{
	try{
	test.pass("login started");
	
	FacebookLogin f=new FacebookLogin(driver, test);
	f.LoginMethod();
	test.pass("login completed succesfully");
	}
	catch(Exception e)
	{
		System.out.println(2);
		CommonMethod ref=new CommonMethod(driver);
		MediaEntityModelProvider mediaModel;
		try {
			mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ref.screenshot("screenshot6.png")).build();
			test.fail("something went wrong in login page", mediaModel);

		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	
	}
	
	}
	
	
	
@AfterTest	
public void tearDown()
{
	driver.quit();
	test.pass("End of Execution");

	extent.flush();
	}
	
	
	
	
	
	
	
}
