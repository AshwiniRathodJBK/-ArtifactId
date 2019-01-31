package pageobject.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MyMainClass 
{
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("https://dev.tracko.co.in/");
	}
	@Test
	public void signUp()
	{
		WebElement name=driver.findElement(By.xpath(""));
		name.sendKeys("");
	}
	@Test
	public void login()
	{
		
	}
	@Test
	public void product()
	{
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit(); 
	}

}
