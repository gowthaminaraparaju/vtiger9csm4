package myOwnPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider1 {
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="admin";
		obj[0][1]="manager";
		obj[1][0]="trainee";
		obj[1][1]="manager";
		return obj;
		
	}
	@Test(dataProvider="data")
	public void login(String username, String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		driver.quit();
		
	}

}
