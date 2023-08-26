package Retryanalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScript {
	@Test
	public void demo1()
	{
		System.out.println("demo1");
	}
	@Test(retryAnalyzer=Retryanalyzer.RetryImplementation.class)
	public void demo2()
	{
		System.out.println("demo2");
		Assert.fail();
	}
	

}
