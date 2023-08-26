package vtiger;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewEvent {

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
		WebElement dropdown=driver.findElement(By.id("qccombo"));
		Select s=new Select(dropdown);
		s.selectByValue("Events");
		WebElement e2=driver.findElement(By.xpath("//b[text()='Create To Do']"));
	
		if(e2.isDisplayed())
			System.out.println("create to do is displayed");
		else
			System.out.println("create to do is not displayed");
		Random r=new Random();
		int n=r.nextInt(100);
		String subject="meet";
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.id("jscal_trigger_date_start")).click();
		String reqdate="19";
		int reqmonth=10;
		int reqyear=2025;
		String commonpath="//div[@class='calendar'] and contains(@style,'block')]/descendant::td[%s]";
		String actualmonthyear=driver.findElement(By.xpath(formatpath(commonpath,"@class='title'"))).getText();
		System.out.println(actualmonthyear);

		String[] str=actualmonthyear.split(", ");
		int actyear=Integer.parseInt(str[1]);
		while(actyear<reqyear)
		{   
			driver.findElement(By.xpath(formatpath(commonpath,"text()='>>'"))).click();
			actualmonthyear=driver.findElement(By.xpath(formatpath(commonpath,"@class='title'"))).getText();
			System.out.println(actualmonthyear);
			str=actualmonthyear.split(", ");
			actyear=Integer.parseInt(str[1]); 
			
		}
		int actmonth=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		System.out.println(actmonth);
		while(actmonth<reqmonth)
		{   
			driver.findElement(By.xpath(formatpath(commonpath,"text()='>'"))).click();		
			actualmonthyear=driver.findElement(By.xpath(formatpath(commonpath,"@class='title'"))).getText();
			System.out.println(actualmonthyear);
			str=actualmonthyear.split(", ");
			actmonth=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
			System.out.println(actmonth);
		}
			while(actmonth>reqmonth)
			{
				driver.findElement(By.xpath(formatpath(commonpath,"text()='<'"))).click();
			actualmonthyear=driver.findElement(By.xpath(formatpath(commonpath,"@class='title'"))).getText();
			System.out.println(actualmonthyear);
			str=actualmonthyear.split(", ");
			actmonth=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
			System.out.println(actmonth);
			}
		driver.findElement(By.xpath(formatpath(commonpath,"text()='"+reqdate+"'"))).click();
	}
			public static String formatpath(String commonpath,String replacedata)
			{
				return String.format(commonpath,replacedata);
			}
		}
	

