package util;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoadProperty 
{
	Properties prop=null;
	WebDriver driver;
	public LoadProperty(String Location)
	{
		 prop=new Properties();
		 try {
			prop.load(new FileInputStream(Location));
		 	} catch (Exception e) 
			{
		 		System.out.println("Error with Property file");			
		 		
			} 
	}
	
	
	public   String getProp(String Key)
	{
		return prop.getProperty(Key);
	}
	
	
	public By getElement(String Value)
	  {
		String LocatorType=prop.getProperty(Value).split(":=")[1];
		String LocatorValue=prop.getProperty(Value).split(":=")[0];
				
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
}
