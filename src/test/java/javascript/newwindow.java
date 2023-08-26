package javascript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newwindow {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		driver.quit();
	}

}
