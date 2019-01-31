package com.jbk;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

public class FacebookLoginPage {

public WebDriver driver;
 ExtentTest test;
 /*
 WebElement userName=driver.findElement(By.xpath("//input[@id='email']"));
	
 WebElement passWord=driver.findElement(By.xpath("//input[@id='pass']"));
 
 WebElement LoginButton=driver.findElement(By.xpath("//input[@type='submit']"));
 
 
 */
 @FindBy(how=How.ID, using= "email")
	WebElement userName;

	@FindBy(id = "pass")
	WebElement passWord;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement LoginButton;

 
 
 public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	public FacebookLoginPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	public void LoginMethod()
	{
		try
		{
		
	    
		userName.sendKeys("ashwinirathod12345@gmail.com");
		test.pass("Entered username in login page");
		
		passWord.sendKeys("9657709374");
		test.pass("Entered password in login page");
		
		
		LoginButton.click();
		test.pass("clicked login button in login page");
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/login.php?login_attempt=1&lwv=110");
		}
		catch(Exception e)
		{ 
			try
			{
				test.fail("LoginMethod failed in login page").addScreenCaptureFromPath(screenshot("screenshot1.png"));
				
				
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
			
			MediaEntityModelProvider mediaModel;
			try
			{
				mediaModel=MediaEntityBuilder.createScreenCaptureFromPath(screenshot("screenshot2.png")).build();
				test.fail("LoginMethod failed in Login Page using MediaEntityModelProvider", mediaModel);
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	public String screenshot(String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String des=System.getProperty("user.dir")+"\\Screens\\"+screenShotName+".png";
		
		File destination = new File(des);
		FileUtils.copyFile(src, destination);
		return des;
	}
}
