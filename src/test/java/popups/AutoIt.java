
package popups;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIt {

	public static void main(String[] args) throws InterruptedException,IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Upload Resume']")).click();
		
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\gowthami\\OneDrive\\Desktop\\subbu\\subbu.exe");
		Thread.sleep(3000);
		driver.quit();

		
	}

}

