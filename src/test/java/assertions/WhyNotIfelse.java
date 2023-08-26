package assertions;

import org.testng.annotations.Test;

public class WhyNotIfelse {
	@Test
	public void demo()
	{
		String s="hello";
		String s2="Hello";
		if(s.equals(s2))
			System.out.println("pass");
		else
			System.out.println("fail");
	}

}
