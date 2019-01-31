package com.jbk;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogDemo {
public static void main(String[] args) {
	
	Logger log=Logger.getLogger("LogDemo");
	PropertyConfigurator.configure("Resource/log4j.properties");
	
	System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	//logger.info("starting with automation is chrome");
	 WebDriver driver= new ChromeDriver();
	 
	 log.info("firefox opened");
	 
	 driver.manage().window().maximize();
	 log.info("window maximized");
	 
	 driver.get("file:///C:/Offline%20Website/index.html");
	 
	 log.info("app launched");
	 
	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 
	 log.info("Login successful");
	 
	 String s=driver.getTitle();
	 System.out.println("page title is :"+s);
	 driver.quit();
}
}
