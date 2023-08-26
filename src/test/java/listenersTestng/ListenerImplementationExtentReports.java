package listenersTestng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationExtentReports implements ITestListener {
	private ExtentReports report;
	private ExtentTest test;
	private static ExtentTest stest;
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setReportName("Extent Reports");
		spark.config().setDocumentTitle("Vtiger-Crm");
		spark.config().setTheme(Theme.STANDARD);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "gowthami");
		report.setSystemInfo("Os", System.getProperty("os.name"));
		report.setSystemInfo("os version", System.getProperty("os.version"));
		report.setSystemInfo("java version", System.getProperty("java version"));
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		Capabilities cap=((RemoteWebDriver)(BaseClass2.sdriver)).getCapabilities();
	    report.setSystemInfo("Browser", cap.getBrowserName());
	    report.setSystemInfo("Browser version", cap.getBrowserVersion());
	    test=report.createTest(result.getMethod().getMethodName());
	    stest=test;
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+" pass");
		
	}
		@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+ " fail");
		test.fail(result.getThrowable());
		TakesScreenshot ts=(TakesScreenshot)(BaseClass2.sdriver);
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./failscreenshot/"+result.getMethod().getMethodName()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName());
		test.skip(result.getThrowable());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	
	

}
