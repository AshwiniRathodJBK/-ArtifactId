package com.jbk;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

public class FacebookLogin {
WebDriver driver;
ExtentTest test;
@FindBy(how=How.ID, using="email")
WebElement userName;

@FindBy(id ="pass")
WebElement passWord;

@FindBy(xpath ="//input[@type='submit']")
WebElement LoginButton;

	
	public FacebookLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public FacebookLogin(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginMethod()
	{
		try{
		userName.sendKeys("ashwinirathod12345654@gmail.com");
		test.pass("Entered username in login page");
		
		passWord.sendKeys("965770937445");
		test.pass("Entered password in login page");
		
		LoginButton.click();
		test.pass("clicked login button in login page");
		
		//Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110");
	  Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
		test.pass("finished login process");
		}
		catch(Exception e)
		{
			test.fail("failed to login page");
		}
	}
	}

