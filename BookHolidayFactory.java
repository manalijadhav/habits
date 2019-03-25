package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookHolidayFactory extends Factory {

	public BookHolidayFactory(WebDriver iDriver)
	{
		super(iDriver);
	}
	
	public void BookHoliday(String fname, String lname, String email, String mobile)throws Exception{
		
		driver.findElement(property.getElement("E_FNAME")).sendKeys(fname);
		driver.findElement(property.getElement("E_LNAME")).sendKeys(lname);
		driver.findElement(property.getElement("E_EMAIL")).sendKeys(email);
		driver.findElement(property.getElement("E_MOBILE")).sendKeys(mobile);
		Thread.sleep(1000);
		
		driver.findElement(property.getElement("E_DEPARTURE_DATE")).click();
		Thread.sleep(1000);
		driver.findElement(property.getElement("E_DDATE")).click();
		Thread.sleep(1000);
		driver.findElement(property.getElement("E_PROCEED_BTN")).click();
		Thread.sleep(5000);
		
		System.out.println("Entering OTP");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class='submitOtpForm send']")).click();
		Thread.sleep(1000);
	}
	
	
}
