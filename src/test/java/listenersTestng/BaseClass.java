package listenersTestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeSuite
	public void suiteSetup()
	{
		System.out.println("Before suite");
	}
	@BeforeTest
	public void testSetup()
	{
		System.out.println("Before Test");
	}
	@BeforeClass
	public void classSetup()
	{
		System.out.println("Before class");
	}
	@BeforeMethod
	public void methodSetup()
	{
		System.out.println("Before method");
	}
	@AfterMethod
	public void methodTeardown()
	{
		System.out.println("after method");
	}
	@AfterClass
	public void classTeardown()
	{
		System.out.println("after class");
	}
	@AfterTest
	public void testTeardown()
	{
		System.out.println("after test");
	}
	@AfterSuite
	public void suiteTeardown()
	{
		System.out.println("after suite");
	}
	
}

