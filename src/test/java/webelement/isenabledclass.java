package webelement;
import java.time.Duration;
/*
 * open instagrm and check the login button is enabled or not
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * check the login button is enabled or not
 */
public class isenabledclass {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement loginbutton=driver.findElement(By.xpath("//button[.='Log in']"));
		if(loginbutton.isEnabled())
		{
			System.out.println("enabled");
		}
		else
		{
			System.out.println("disenabled");
		}
		driver.findElement(By.name("username")).sendKeys("4546345");
		driver.findElement(By.name("password")).sendKeys("546545645645");
		if(loginbutton.isEnabled())
		{
			System.out.println("enabled");
			loginbutton.click();
		}
		else
		{
			System.out.println("disenabled");
		}
		driver.quit();
		
		

	}

}
