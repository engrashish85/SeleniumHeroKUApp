package Module9_TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Selenium_ITestListenerClass implements ITestListener {

	@Override
	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the finished test case is - "+Result.getName());
		System.out.println("The end date of the finished test case is - "+Result.getEndDate());
		System.out.println("The current XML for finished test is - "+Result.getCurrentXmlTest());
		System.out.println("The current output directory for finished test is - "+Result.getOutputDirectory());
		System.out.println("The current methods for finished test is - "+Result.getExcludedMethods());
				
	}

	@Override
	public void onStart(ITestContext Result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the started test case is - "+Result.getName());
		System.out.println("The end date of the started test case is - "+Result.getEndDate());
		System.out.println("The current XML for started test is - "+Result.getCurrentXmlTest());
		System.out.println("The current output directory for started test is - "+Result.getOutputDirectory());
		System.out.println("The current methods for started test is - "+Result.getExcludedMethods());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the failed test case is - "+Result.getName());
		System.out.println("The start time of the failed test case is - "+Result.getStartMillis());
		
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the failed onFailureTest test case is - "+Result.getName());
		System.out.println("The start time of the failed onFailureTest test case is - "+Result.getStartMillis());
		
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the skipped test case is - "+Result.getName());
		System.out.println("The start time of the skipped test case is - "+Result.getStartMillis());
		
	}

	@Override
	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the started test case is - "+Result.getName());
		System.out.println("The start time of the started test case is - "+Result.getStartMillis());
				
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the successful test case is - "+Result.getName());
		System.out.println("The start time of the successful test case is - "+Result.getStartMillis());
		
	}
	
}
