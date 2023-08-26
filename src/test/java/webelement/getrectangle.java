package webelement;
/*
 * lauch chromebrowser
 * open myntra.com
 * fetch 400% flat
 * print the x,y,height,width coordinates
 */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getrectangle {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement discount =driver.findElement(By.xpath("//img[contains(@src,'Main-Banner_Desktop_13')]"));
        Rectangle rect=discount.getRect();
        System.out.println("x-coordinate"+rect.getX());
        System.out.println("ycoordinate"+rect.getY());
        System.out.println("height"+rect.getHeight());
        System.out.println("width"+rect.getWidth());
        driver.close();

	}

}
