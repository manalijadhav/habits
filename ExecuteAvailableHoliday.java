package testExecution;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import POM.AvailablePackage;
import POM.LoginFactory;
import util.Base;

public class ExecuteAvailableHoliday extends Base {
	
	@Test(priority=1,dataProvider="Login")
	  public void LoginFactoryTest(String username,String Password) throws Exception
	  {
		LoginFactory search=new LoginFactory(driver);
		search.Login(username,Password);
	  }
	
@DataProvider
	public Object[][] Login() throws Exception
	{
		Object data1[][]=excel.MyDataProvider("Sheet4",2);
		return data1;
	}
	
	
	
	@Test(priority=2,dataProvider="PackageData")
	  public void AvailableFactoryTest(String destination, String Fname,String Sname,String Fname1,String Sname2,String MobileNo,String Email) throws Exception
	  {
		AvailablePackage avail=new AvailablePackage(driver);
		avail.AvailableHoliday(destination, Fname, Sname, Fname1, Sname2, MobileNo, Email);
	  }
	
@DataProvider
	public Object[][] PackageData() throws Exception
	{
		Object data2[][]=excel.MyDataProvider("Sheet3",7);
		return data2;
	}
}
