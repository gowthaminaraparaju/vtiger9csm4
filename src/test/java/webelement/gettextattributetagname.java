package webelement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/* open facebook.com
 * find the login button
 * print the text,tagname,attribute in console
 */
public class gettextattributetagname {
	
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement loginbutton=driver.findElement(By.name("login"));
			System.out.println(loginbutton.getText());
			System.out.println(loginbutton.getTagName());
			System.out.println(loginbutton.getAttribute("data-testid"));
			driver.close();
		}

	}

