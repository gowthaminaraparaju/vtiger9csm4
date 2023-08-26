package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	@Test
	public void demo()
	{
		String s="hello";
		String s2="Hello";
		Assert.assertEquals(s, s2);
		System.out.println("s");
		System.out.println("s2");
	}

}
