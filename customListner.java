
package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class customListner extends Base implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		Test= extent.createTest(result.getName());
		Test.info(result.getName()+" Started");		
	}

	
	public void onTestSuccess(ITestResult result) {
		Test.pass(result.getName()+" Success");
		
	}

	
	public void onTestFailure(ITestResult result)  
	{
		Test.fail(result.getName()+" Fail");
		try {
			Key.getScreenShot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		  Test.fail(result.getName()+" Failed");
		
	}

	
	public void onTestSkipped(ITestResult result) {
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		Test.info("Writing Report");
		extent.flush();
	}

}
