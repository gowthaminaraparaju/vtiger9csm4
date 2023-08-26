package actions;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class practise2 {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement e=driver.findElement(By.xpath("//span[text()='Sign In']"));
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
        driver.findElement(By.xpath("//a[text()='login']")).click();
        driver.switchTo().frame("iframeLogin");
        driver.findElement(By.id("close-pop")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.name("keyword")).sendKeys("soft toys");
        driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
        Thread.sleep(2000);
        WebElement photo=driver.findElement(By.xpath("(//img[@class='product-image '])[1]"));
        File f=photo.getScreenshotAs(OutputType.FILE);
        File dest=new File("./ElementScreenshot/toy.png");
        FileUtils.copyFile(f, dest);
        driver.quit();
        
	}

}
