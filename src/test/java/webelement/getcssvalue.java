

package webelement;

import java.time.Duration;
/*
 * open facebook.com
 * to get css properties of loginbutton
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getcssvalue {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement loginbutton=driver.findElement(By.name("login"));
		System.out.println(loginbutton.getCssValue("font"));
		System.out.println(loginbutton.getCssValue("background-color"));
		System.out.println(loginbutton.getCssValue("color"));
		driver.close();

	}

}
