package testExecution;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.BookHolidayFactory;
import POM.LoginFactory;
import POM.SearchHolidayFactory;
import util.Base;

public class Execute extends Base
{
	@Test(priority=1,dataProvider="Login")
	  public void LoginFactoryTest(String username,String Password) throws Exception
	  {
		LoginFactory search=new LoginFactory(driver);
		search.Login(username,Password);
	  }
	
@DataProvider
	public Object[][] Login() throws Exception
	{
		Object data[][]=excel.MyDataProvider("Sheet4",2);
		return data;
	}
	
	
	

		@Test(priority=2,dataProvider="SearchData")
		  public void SearchHolidayFactoryTest(String dest) throws Exception
		  {
			SearchHolidayFactory search=new SearchHolidayFactory(driver);
			search.SearchHoliday(dest); 
		  }
		
	@DataProvider
		public Object[][] SearchData() throws Exception
		{
			Object data[][]=excel.MyDataProvider("Sheet1",1);
			return data;
		}
	@Test(priority=3,dataProvider="Details")
	  public void UserDetailsTest(String fname, String lname, String email, String mob) throws Exception
	  {
		BookHolidayFactory book=new BookHolidayFactory(driver);
		book.BookHoliday(fname, lname, email,mob); 
	  }
	
@DataProvider
	public Object[][] Details() throws Exception
	{
		Object data1[][]=excel.MyDataProvider("Sheet2", 4);
		return data1;
	}


}
