package vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteExistingLeadTest {

	public static void main(String[] args) {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8888");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(driver.getTitle().contains("vtiger"))
				System.out.println("login page displayed");
			else
				System.out.println("login page not displayed");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).submit();
			if(driver.getTitle().contains("Home"))
				System.out.println("Home page is displayed");
			else
				System.out.println("Homepage is not displayed");
			driver.findElement(By.xpath("//a[text()='Leads']")).click();
			if(driver.getTitle().contains("Leads"))
				System.out.println("leads page is displayed");
			else
				System.out.println("leads page is not displayed");
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			WebElement e=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
            if(e.isDisplayed())
            	System.out.println("creating new lead is displayed");
            else
            	System.out.println("creating new lead is not displayed");
            Random random=new Random();
            int n=random.nextInt(100);
            String lastname="abc"+n;
            String company="infosys"+n;
            driver.findElement(By.name("lastname")).sendKeys(lastname);
            driver.findElement(By.name("company")).sendKeys(company);
            driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
           
            driver.findElement(By.xpath("//input[@name='Delete']")).click();
            Alert al=driver.switchTo().alert();
            al.accept();
            driver.findElement(By.xpath("//input[@id='90']")).click();
           WebElement detailsdisp= driver.findElement(By.xpath("//td[normalize-space(text())='Showing Records 1 - 8 of 8']"));
           System.out.println(detailsdisp);
           driver.findElement(By.xpath("//input[@value='Delete']")).click();
           al.accept();
           WebElement detailsdisp1= driver.findElement(By.xpath("//td[normalize-space(text())='Showing Records 1 - 7 of 7']"));
           System.out.println(detailsdisp1);
           WebElement signicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
   		Actions a=new Actions(driver);
   		a.moveToElement(signicon).perform();
   		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
   		driver.quit();
   		
}  
	}


