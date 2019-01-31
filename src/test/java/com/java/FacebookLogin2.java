package com.java;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookLogin2 {
	static Logger logger = Logger.getLogger(Log4jClass.class);

 WebDriver driver;
	
 public FacebookLogin2(WebDriver driver)
 {
	 this.driver=driver;
 }
 public void FbLogin()
 {
	 logger.info("inside login method");
	 try{
	 WebElement user=driver.findElement(By.xpath("//input[@id='emai']"));
	 user.sendKeys("ashwinirathod12345@gmail.com");
	 logger.info("succesfully entering a username");
	 }
	 catch(Exception e)
	 {
		 logger.error("unable to locate usename element");
	 }
	 
	 try
	 {
	 WebElement pass=driver.findElement(By.xpath("//input[@id='pass']"));
	 pass.sendKeys("9657709374");
	 logger.info("successfully entering password");
	 }
	 catch(Exception e)
	 {
		 logger.error("unable to locate password elemnt "); 
	 }
	 
	 try{
	 WebElement loginbutton=driver.findElement(By.xpath("//input[@type='submit']"));
	 loginbutton.click();
	 logger.info("succssfully click login button");
	 }
	 catch(Exception e)
	 {
		 logger.error("unable to locate login button");
	 }
	
	 logger.info("success");
 }
 
}
