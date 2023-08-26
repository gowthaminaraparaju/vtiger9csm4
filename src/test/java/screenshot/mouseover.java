
package screenshot;
/*
 * open myntra and mouse over on kids
 * click on learning and development tools
 * check the text is present in page or not and pass/fail.
 */
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseover {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement kids=driver.findElement(By.xpath("//a[text()='Kids' and @class='desktop-main']"));
		Actions a=new Actions(driver);
		a.moveToElement(kids).perform();
		driver.findElement(By.xpath("//a[text()='Learning & Development']")).click();
		String pagetitle=driver.findElement(By.xpath("//div[@class='filter-summary-filter']")).getText();
		if(pagetitle.equals("Learning And Development Toys"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		driver.quit();
		}
		
		

	}	


