package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class multiselect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement dropdown=driver.findElement(By.id("cars"));
		Select s=new Select(dropdown);
		if(s.isMultiple())
		{
			System.out.println("multiple");
			s.selectByIndex(0);
			s.selectByValue("90");
			s.selectByVisibleText("INR 200 - INR 299 ( 3 )");
			Thread.sleep(2000);
		     System.out.println(s.getFirstSelectedOption().getText());
		     List<WebElement> element=(s.getAllSelectedOptions());
		     for(WebElement elements:element)
		     {
		    	 System.out.println(elements.getText());
		     }
		     s.deselectByIndex(0);
		     s.deselectByValue("90");
		     s.deselectByVisibleText("INR 200 - INR 299 ( 3 )");
		}
		else
			System.out.println("single select");
		driver.quit();
		
				

	}

}
