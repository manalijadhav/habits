package POM;

import org.openqa.selenium.WebDriver;

public class LoginFactory extends Factory {
	public LoginFactory(WebDriver iDriver)
	{
		super(iDriver);
	}

	public void Login(String username,String Password)
	{
		driver.findElement(property.getElement("E_LOGIN")).click();
		driver.findElement(property.getElement("E_EM")).sendKeys(username);;
		driver.findElement(property.getElement("E_PWD")).sendKeys(Password);;
		driver.findElement(property.getElement("E_LG")).click();
		
	}
}