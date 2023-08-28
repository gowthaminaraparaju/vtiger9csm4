package actions;
/*
 * mouse over on courses and click on selinium training  and double click on value.
 */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//this is second workspace
public class doubleclick {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement coursetab=driver.findElement(By.id("course"));
		Actions a=new Actions(driver);
		a.moveToElement(coursetab).perform();
		driver.findElement(By.xpath("//span/a[text()='Selenium Training']")).click();
		WebElement quantity=driver.findElement(By.id("quantity"));
		System.out.println("initial value"+quantity.getAttribute("value"));
		a.doubleClick(driver.findElement(By.id("add"))).perform();
		System.out.println("final value"+quantity.getAttribute("value"));
		driver.quit();
	}

}

