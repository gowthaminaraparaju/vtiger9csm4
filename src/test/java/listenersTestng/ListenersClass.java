package listenersTestng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.err.println("on test start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.err.println("on test success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.err.println("on test failure");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.err.println("on test skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.err.println("on start");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.err.println("on finish");
			}
	
	

}
