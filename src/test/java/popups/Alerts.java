
package popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();//js alert
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();//js confirm
		System.out.println(al.getText());
		al.dismiss();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();//js prompt
		System.out.println(al.getText());
		al.sendKeys("hii good morning");
		al.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.quit();
	

	}

}
