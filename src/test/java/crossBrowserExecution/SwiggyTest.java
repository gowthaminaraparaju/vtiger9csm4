package crossBrowserExecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwiggyTest extends BaseClass {
	@Test
	public void swiggyTest() {
		driver.get("https://www.swiggy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 WebElement swiggyImage=driver.findElement(By.xpath("//*[name()='svg']"));
		 if(swiggyImage.isDisplayed()) {
			 System.out.println("Swiggy page is displayed");
		 }
		 else
			 System.out.println("swiggy page not found");
	}

}
