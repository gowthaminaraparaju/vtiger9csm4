package basics;
import org.openqa.selenium.By;
//open browser
//enter demo.acctime.com
//click on forgot your password
//click on return to login page
//close the browser
import org.openqa.selenium.chrome.ChromeDriver;

public class forgotpassword {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Forgot")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Return")).click();
		driver.close();
	}

	
}
