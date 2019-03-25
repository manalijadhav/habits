package util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM.BookHolidayFactory;
import POM.LoginFactory;
import POM.SearchHolidayFactory;
import POM.SignUpFactory;

public class Base {
public  WebDriver driver; 
public static ExtentReports extent;
public static ExtentTest Test;
public static KeyWords Key;


public SearchHolidayFactory SH;
public BookHolidayFactory BH;
public LoginFactory LF;
public Excel excel;
 
@BeforeTest(alwaysRun=true)

@Parameters("browser")
public void beforeTest(String browser)
 {
		extent = new ExtentReports();
    	extent.attachReporter(new ExtentHtmlReporter("Sample1.html"));
    	Key=new KeyWords();
    	excel=new Excel(".\\Book1.xlsx");
	 if(browser.equalsIgnoreCase("firefox"))
		 driver=Key.browserStart("firefox");
	 
	 else if(browser.equalsIgnoreCase("chrome"))
		 driver=Key.browserStart("chrome");
	 
	  driver.get("https://in.via.com/");
	  LF=new LoginFactory(driver);
	  SH=new SearchHolidayFactory(driver);
	  BH=new BookHolidayFactory(driver);
	  
 }

 @AfterTest
 public void afterTest()
 {
	  driver.quit();
 }
}
