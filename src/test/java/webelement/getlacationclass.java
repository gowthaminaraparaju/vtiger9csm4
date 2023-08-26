package webelement;

import java.time.Duration;
/*
 * open browser
 * enter swiggy.com
 * get the location of swiggy lobo
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getlacationclass {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement logo=driver.findElement(By.xpath("//*[name()='svg']"));
		Point location=logo.getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println(x+""+y);
		System.out.println(location);
		driver.close();

	}

}
