package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchHolidayFactory extends Factory{
	
	public SearchHolidayFactory(WebDriver iDriver)
		{ 
			super(iDriver);
		}

		public void SearchHoliday(String destination)throws Exception
		{
			
			Actions action= new Actions(driver);
			driver.findElement(property.getElement("E_HOLIDAYS")).click();
			Thread.sleep(3000);
			String url1=driver.getCurrentUrl();
			System.out.println(url1);
			if (url1.contains("via.com"))
			{
				
				System.out.println("Internal link exists 1st Verification");
			}
			else
			{
				
				System.out.println("External link");
			}
			driver.findElement(property.getElement("E_DESTINATION")).sendKeys(destination);

			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']/li[2]")));
			
		WebElement E=driver.findElement(By.xpath("//ul[@id='ui-id-1']/li//*[contains(text(),'"+destination+"')]"));  
			action.moveToElement(E).click(E).perform();
			
			driver.findElement(property.getElement("E_DATE_PICKER")).click();
		//	Thread.sleep(3000);
			driver.findElement(property.getElement("E_DATE")).click();
			 
			driver.findElement(property.getElement("E_ROOMS")).click();
	
			driver.findElement(property.getElement("E_DONE")).click();
			System.out.println("clicked on done button");
			
			driver.findElement(property.getElement("E_SEARCH")).click();
			System.out.println("clicked on submit button");
	
			driver.findElement(property.getElement("E_BOOK1")).click();
			System.out.println("clicked on BOOK1 button");
	
			driver.findElement(property.getElement("E_BOOK2")).click();
			System.out.println("clicked on BOOK2 button");
			Thread.sleep(6000);
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(property.getElement("E_FNAME")));
		}
	}


