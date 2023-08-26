package vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisationWithTypeAndIndustryTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page displayed");
		else
			System.out.println("Login page not displayed");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
			System.out.println("Home page is not displayed");
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		WebElement e=driver.findElement(By.xpath("(//a[text()='Organizations'])[2]"));
		if(e.isDisplayed())
			System.out.println("organisation page is displayed");
		else
			System.out.println("Organisation page is not displayed");
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Random r=new Random();
		int n=r.nextInt(100);
		String orgname="tcs"+n;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("industry")).sendKeys("Banking");
		driver.findElement(By.name("accounttype")).sendKeys("Analyst");
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		WebElement e1=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if(e1.isDisplayed())
			System.out.println("title is dislayed");
		else
			System.out.println("title is not displayed");
		WebElement sign=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(sign).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
		
		
		
		
		
			
		
		
		

	}

}
