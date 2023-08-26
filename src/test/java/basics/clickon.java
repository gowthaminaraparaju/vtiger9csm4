package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class clickon {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Create a Page")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
