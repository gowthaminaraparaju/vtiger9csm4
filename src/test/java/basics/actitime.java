package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actitime {

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://demo.actitime.com/login.do");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.id("//input[@name='username']")).sendKeys("admin");
		  driver.findElement(By.name("//input[@name='pwd']")).sendKeys("manager");
		  driver.findElement(By.id("//div[text()='Login ']")).click();
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		  try
		  {
			  boolean status=wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
			  if(status)
			  {
				  System.out.println("home page displayed");
				  
			  }
		  }
		  catch(Exception e)
		  {
			  System.out.println("login failed");
		  }
		  driver.close();

	}

}
