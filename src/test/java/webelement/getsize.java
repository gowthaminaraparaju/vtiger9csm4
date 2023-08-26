package webelement;
/*
 * launch chromebrowser
 * maximize the window
 * get swiggy.com
 * give implicit wait
 * get the dimensions of the phoneimage appear on the webpage
 */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getsize {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement phoneimage=driver.findElement(By.xpath("//img[@class='_2SJnz']"));
        Dimension d=phoneimage.getSize();
       int height= d.getHeight();
        int width=d.getWidth();
        System.out.println(height+"   "+width);
        driver.close();
	}

}
