package webelement;

import java.time.Duration;
import java.util.List;
/*
 * open amazon
 * find x path for footer part
 * get the text of all the elements on the footer section by limiting the driver scope
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class limitwebdriver {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement footer=driver.findElement(By.xpath("//div[@class='navFooterVerticalColumn navAccessibility']"));
		Thread.sleep(2000);
         List<WebElement> footerlinks=footer.findElements(By.tagName("a"));
         for(WebElement links:footerlinks)
         {
        	 System.out.println(links.getText());
         }
         driver.quit();
	}

}
