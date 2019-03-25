package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpFactory extends Factory {
	
	public SignUpFactory(WebDriver iDriver) 
	{
		super(iDriver);
	}

	public void SIGNUP(String userName,String PassWord,String name, String mobNo) throws Exception
	{
		//String dataA[]=data.split(",");
		driver.findElement(property.getElement("E_SIGNIN")).click();
		WebDriverWait wt=new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(property.getElement("E_SIGNUP_BTN"))));
		driver.findElement(property.getElement("E_SIGNUP_BTN")).click();
		driver.findElement(property.getElement("E_EM_SIGNUP")).sendKeys(userName);
		driver.findElement(property.getElement("E_PWD_SIGNUP")).sendKeys(PassWord);
		driver.findElement(property.getElement("E_NAME_SIGNUP")).sendKeys(name);
		driver.findElement(property.getElement("E_MOB_SIGNUP")).sendKeys(mobNo);
		driver.findElement(property.getElement("E_CREATE_ACC")).click();
		driver.findElement(property.getElement("E_SIGNUP_BTN")).click();
		
		
	}
}
