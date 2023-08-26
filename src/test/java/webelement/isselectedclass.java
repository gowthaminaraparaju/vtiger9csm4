
 package webelement;
 /*
  * open facebook.com
  * click on create new account
  * check the female radio button is selected or not
  * now click on female radio button and check the button is selected or not
  */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isselectedclass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		WebElement radiobutton=driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
		
		if(radiobutton.isSelected())
		{
			System.out.println("selected");
		}
		else
			
		{
			System.out.println("not selected");
		}
		radiobutton.click();
		if(radiobutton.isSelected())
		{
			System.out.println("selected");
		}
		else
		{
			System.out.println("not selected");
		}
		driver.quit();
		
		

	}

}
