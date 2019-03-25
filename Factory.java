package POM;

import org.openqa.selenium.WebDriver;

import util.LoadProperty;


public class Factory {
	public	WebDriver driver;
	public	LoadProperty property;
	public Factory(WebDriver iDriver)
	{
		this.driver=iDriver;
		property=new LoadProperty(".\\OR.property");
	}
}
