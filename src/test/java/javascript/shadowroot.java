package javascript;

import java.time.Duration;
/*
 * if we cant find element directly then we have to check whether it is under shadow root
 * then use javascript executerj
 * 
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadowroot {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("chrome://downloads/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object obj=js.executeScript("return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
        WebElement element=(WebElement)obj;
        Thread.sleep(2000);
        element.sendKeys("common io");//any data we can pass in send keys
        Thread.sleep(2000);
        driver.quit();
	}

}
