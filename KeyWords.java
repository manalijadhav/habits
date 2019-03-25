package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class KeyWords
{
	private WebDriver driver;
	public  WebDriver browserStart(String name)
	{
		if(name.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public  WebDriver browserStart(String name,String url)
	{
		driver=browserStart(name);
		driver.get(url);
		return driver;
	}
	
	public  void getScreenShot(String Name)
	{	
		Date d=new Date();
		System.out.println("Before "+d.toString());
		String date=d.toString().replaceAll(" ", "_").replaceAll(":","_");
		System.out.println("After "+date);
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(".\\"+Name+date+".png"));
		} catch (IOException e) {
			System.out.println("Error  while taking screenshot");
			
		}
	}
	/*public KeyWords(WebDriver idriver)
	{
		this.driver=idriver;
	}*/

	public void openUrl(String url)
	{
		driver.get(url);
	}

	public void type(String Locator,String text)
	{
		driver.findElement(getElement(Locator)).sendKeys(text);
	}
	public void click(String Locator)
	{
		driver.findElement(getElement(Locator)).click();;
	}
	public void dropDown(String Locator,String visibletext)
	{
		new Select(driver.findElement(getElement(Locator))).selectByVisibleText(visibletext);
	}
	
	public By getElement(String Locator)
	  {
		String LocatorType=Locator.split(":=")[1];
		String LocatorValue=Locator.split(":=")[0];
				
		By B=null;
		  if(LocatorType.equalsIgnoreCase("linktext"))
			B=  By.linkText(LocatorValue);
		  else if (LocatorType.equalsIgnoreCase("xpath"))	 
			B=  By.xpath(LocatorValue);
		  else if (LocatorType.equalsIgnoreCase("id"))	 
				B=  By.id(LocatorValue);
		  else if (LocatorType.equalsIgnoreCase("name"))	 
				B=  By.name(LocatorValue);
		  else if (LocatorType.equalsIgnoreCase("css"))	 
				B=  By.cssSelector(LocatorValue);
		  else 
			  System.out.println("Invalid Locator");
		  return B;
	  }
	
	public  boolean verifyOnVisibilty(int time,By ByLocator,String ScreenName) throws Exception
	{
		boolean status=false;
		try{
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(driver.findElement(ByLocator)));
			return status;
		}
		catch(TimeoutException TimeOut)
		{
			getScreenShot(ScreenName);
			status=false;
			Assert.fail();
			System.out.println("Hi");
			return status;
		}
	}
	public  boolean verifyOnInVisibilty(int time,By ByLocator,String ScreenName) throws Exception
	{
		boolean status=false;
		try{
			new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(driver.findElement(ByLocator)));
			status= true;
			return status;
		}
		catch(TimeoutException TimeOut)
		{
			getScreenShot(ScreenName);
			status=false;
			return status;
		}
	}
	
	public  void checkAssertion(String actual,String expected,String message,String ScreenName){
		try {
			Assert.assertEquals(actual, expected,message);
		} catch(AssertionError ae){
			getScreenShot(ScreenName);

			throw ae;
		}
	}
	
	public  void checkAssertion(boolean actual,boolean expected,String message,String ScreenName){
		try {
			Assert.assertEquals(actual, expected,message);
		} catch(AssertionError ae){
			getScreenShot(ScreenName);

			throw ae;
		}
	}
}
