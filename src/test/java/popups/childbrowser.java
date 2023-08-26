package popups;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class childbrowser {

	public static void
	main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F13 (Nightsky Green, 64 GB)']")).click();
		String parentid=driver.getWindowHandle();//to get the parent window address
		Set<String> all=driver.getWindowHandles();//to get the list of window address
		for(String s:all)
		{
			driver.switchTo().window(s);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		driver.close();
		driver.switchTo().window(parentid);
		driver.navigate().refresh();
		WebElement carticon=driver.findElement(By.xpath("//div[text()='1']"));
		if(carticon.getText().endsWith("1"))
			System.out.println("added item to cart succesfully");
		else
			System.out.println("not added to cart");
		driver.quit();
		
		

	}

}
