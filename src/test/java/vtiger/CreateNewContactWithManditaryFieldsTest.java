package vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateNewContactWithManditaryFieldsTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		 driver.findElement(By.id("submitButton")).submit();
		 
		if(driver.getTitle().contains("vtiger"))
			System.out.println("vtiger page is displayed");
		else
			System.out.println("vtiger page not displayed");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if(driver.getTitle().contains("Contacts"))
			System.out.println("Contacts page is displayed");
		else
			System.out.println("Contacts page is not displayed");
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement e=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	if(e.isDisplayed())
		System.out.println("create new contact page is displayed");
	else
		System.out.println("create new contact page is not displayed");
	Random random=new Random();
	int randomnum=random.nextInt(100);
	String lastname="gopal"+randomnum;
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	String title=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(title.contains(lastname))
		System.out.println("contact title is displayed");
	else
	 System.out.println("contacts title page is not displayed");
	WebElement icon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions a=new Actions(driver);
	a.moveToElement(icon).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.quit();
	
	

}
}
