package com.jbk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MyMainClass {
WebDriver driver;
ExtentReports extent;
ExtentTest test;
String phoneNumber="9657709374";
String passwordText="test@123";
String emailText="saurab12352@gmail.com";

@BeforeTest
public void setUp()
{
	//initialize report means it creating blank report
	ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("Resource/Tracko.html");
	
	
	//initialize extent report
	extent=new ExtentReports();
	
	//attach onlu html reporter
	extent.attachReporter(htmlReporter);
	
	//we have taken this class and try to start extent report
	test=extent.createTest("Tracko Regression");
	
	
	// after that what we have in report that we can write below
	
	test.pass("Starting with automation"); //we will see this line in report
	
	System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	driver= new ChromeDriver();
	
	test.pass("our browser get initiated");
	
	driver.get("https://dev.tracko.co.in/");
	
	test.pass("my url launched successfully");
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	}  
@Test(priority=1)
public void signUp()
{
	test.pass("Staring with signup process");
	
	}

@Test(priority=2)
public void login()
{
	
	
	}

@Test(priority=3)
public void product()
{
	}

@AfterTest
public void tearDown()
{
	test.pass("end of execution");
	driver.quit();
	extent.flush();       //whatever we have wriiten in report for that we required this line
}

}
