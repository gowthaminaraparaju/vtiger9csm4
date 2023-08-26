package webelement;
/*
 * check the lobo is displayed or not in selenium.dev website
 */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isdisabled {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement lobo=driver.findElement(By.xpath("//*[name()='svg'][@id='Layer_1']"));
		if(lobo.isDisplayed())
		{
			System.out.println("displayed");
		}
		else
		{
			System.out.println("not displayed");
		}
		driver.quit();

	}

}
