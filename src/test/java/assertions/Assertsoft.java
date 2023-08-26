package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertsoft {
	@Test
	public void demo()
	{
		String s="hello";
		String s2="Hello";
		SoftAssert soft =new SoftAssert();
         soft.assertEquals(s, s2);
		
		System.out.println(s);
		System.out.println(s2);
		soft.assertAll();
	}
}
	


