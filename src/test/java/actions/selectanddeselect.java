package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectanddeselect {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement dropdown=driver.findElement(By.id("gh-cat"));
		Select s=new Select(dropdown);
		s.selectByIndex(3);
		Thread.sleep(2000);
		s.selectByValue("625");
		Thread.sleep(2000);
		s.selectByVisibleText("Crafts");
		Thread.sleep(2000);
		if(s.isMultiple())
			System.out.println("multiselect");
		else
			System.out.println("single select");
		List<WebElement> dropdownlist=s.getOptions();
		for(WebElement e:dropdownlist)
			System.out.println(e.getText());
		driver.quit();
		
		
		

	}

}
