package vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_organisation {

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
			System.out.println("home page displayed");
		else
			System.out.println("home page not displayed");
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("organisation page displayed");
		else
			System.out.println("organisation page not found");
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		WebElement createorg=driver.findElement(By.xpath("//span[text()='Creating New Organization']"));
		if(createorg.isDisplayed())
			System.out.println("create new organisation page is displayed");			
		else
		System.out.println("create new organisation page is not found");
		Random random=new Random();
		int randomnum=random.nextInt(100);
		String orgname="tcs"+randomnum;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		String neworgname=driver.findElement(By.className("dvHeaderText")).getText();
		if(neworgname.contains(orgname))
			System.out.println("organisation created successfully");
		else
			System.out.println("not created");
		WebElement signicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(signicon).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
		
		
		
		
			
		
		
			

	}

}
