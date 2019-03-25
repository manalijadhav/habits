package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvailablePackage extends Factory {

	public AvailablePackage(WebDriver iDriver) {
	
		super(iDriver);
		
	}
	
	public void AvailableHoliday(String destination, String Fname,String Sname,String Fname1,String Sname2,String MobileNo,String Email)throws Exception
	{
		Actions action= new Actions(driver);
		
		driver.findElement(property.getElement("E_HOLIDAYS")).click();
		Thread.sleep(3000);
		
		String url2=driver.getCurrentUrl();
		System.out.println(url2);
		if (url2.contains("via.com"))
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
	
				driver.findElement(property.getElement("E_DATE")).click();
				 
				driver.findElement(property.getElement("E_ROOMS")).click();
		
				driver.findElement(property.getElement("E_DONE")).click();
				System.out.println("clicked on done button");
				
				driver.findElement(property.getElement("E_SEARCH")).click();
				System.out.println("clicked on submit button");
		
				driver.findElement(property.getElement("E_BOOK1")).click();
				System.out.println("clicked on BOOK1 button");
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"holidaysPriceCalendar\"]/div/div[2]/div[5]/div[4]/div/div")).click();
				System.out.println("clicked on ABOOK1 button");
				Thread.sleep(3000);

		driver.findElement(property.getElement("E_Title1")).click();
		driver.findElement(property.getElement("E_Title")).click();
		Thread.sleep(3000);
		driver.findElement(property.getElement("E_FirstAdultName")).sendKeys(Fname);
		driver.findElement(property.getElement("E_SecondName")).sendKeys(Sname);
		driver.findElement(property.getElement("E_Day1")).click();
		driver.findElement(property.getElement("E_Day")).click();
		driver.findElement(property.getElement("E_Month1")).click();
		driver.findElement(property.getElement("E_Month")).click();
		driver.findElement(property.getElement("E_Year1")).click();
		driver.findElement(property.getElement("E_Year")).click();
		Thread.sleep(2000);
		
		driver.findElement(property.getElement("E_Title21")).click();
		driver.findElement(property.getElement("E_Title2")).click();
		Thread.sleep(1000);
		
		driver.findElement(property.getElement("E_FirstName2")).sendKeys(Fname1);
		driver.findElement(property.getElement("E_SecondName2")).sendKeys(Sname2);
		driver.findElement(property.getElement("E_Day21")).click();
		driver.findElement(property.getElement("E_Day2")).click();
		driver.findElement(property.getElement("E_Month21")).click();
		driver.findElement(property.getElement("E_Month2")).click();
		driver.findElement(property.getElement("E_Year21")).click();
		driver.findElement(property.getElement("E_Year2")).click();
		
		driver.findElement(property.getElement("E_MobileNo")).sendKeys(MobileNo);
		Thread.sleep(1000);
		driver.findElement(property.getElement("E_Email")).sendKeys(Email);
		Thread.sleep(1000);
		driver.findElement(property.getElement("E_Checkbox")).click();
		driver.findElement(property.getElement("E_MakePayment")).click();
		Thread.sleep(1000);
		driver.findElement(property.getElement("E_ProceedPayment")).click();
		Thread.sleep(1000);

	}
}

