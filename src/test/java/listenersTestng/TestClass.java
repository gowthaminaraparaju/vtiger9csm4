package listenersTestng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(listenersTestng.ListenersClass.class)

public class TestClass extends BaseClass{
	@Test
	public void testMethod1()
	{
		System.out.println("Test1");
	}
	

}
