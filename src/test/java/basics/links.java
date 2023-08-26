package basics;
/*
 * open browser
 * enter facebook.com
 * fetch all the links in the webpage
 * print the text links in yhe console
 * close the browser
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class links {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		List<WebElement>links=driver.findElements(By.tagName("a"));
		for(WebElement link:links)
		{
			System.out.println(link.getText());
		}
		Thread.sleep(2000);
		driver.close();
	}

}
