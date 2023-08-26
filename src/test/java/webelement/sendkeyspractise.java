package webelement;

import java.time.Duration;

/*
 * forget password by using control and enter
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sendkeyspractise {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Forgotten password?")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		Thread.sleep(2000);
		driver.close();
		}
	
	

}
