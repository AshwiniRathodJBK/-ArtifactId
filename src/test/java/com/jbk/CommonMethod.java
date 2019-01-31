package com.jbk;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonMethod {
 WebDriver driver;
public CommonMethod(WebDriver driver)
{
	this.driver=driver;
	
	}
	public void waitMethod(int x)
	{
		try{
			Thread.sleep(x);
		}
		catch(InterruptedException e)
		{
       e.printStackTrace();
	}
}
	
	public String screenshot(String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\Screens\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;        
	}
	
}