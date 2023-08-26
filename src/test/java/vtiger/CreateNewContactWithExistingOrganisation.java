package vtiger;


import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateNewContactWithExistingOrganisation {

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
			System.out.println("home page is not displayed");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if(driver.getTitle().contains("Contacts"))
			System.out.println("Contacts page is displayed");
		else
			System.out.println("contacts page is not displayed");
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement e=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(e.isDisplayed())
			System.out.println("create new contact page is displayed");
		else
			System.out.println("create new contact page is not displayed");
		Random random=new Random();
		int n=random.nextInt();
		String lastname="gopal"+n;
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		String parent=driver.getWindowHandle();
		Set<String> all=driver.getWindowHandles();
		for(String s:all)
		{
			driver.switchTo().window(s);
		}
		driver.findElement(By.id("search_txt")).sendKeys("tcs42");
		driver.findElement(By.name("search")).click();
		WebElement e1=driver.findElement(By.xpath("//a[text()='tcs42']"));
		if(e1.getText().equals("tcs42"))
			System.out.println("organisation name is displayed");
		else
			System.out.println("organisation name is not displayed");
		e1.click();
		driver.switchTo().window(parent);
		WebElement signicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(signicon).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		

	}

}



