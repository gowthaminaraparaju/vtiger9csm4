package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {

	public static void main(String[] args) {//authentication popup
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();//in url only we hve to write usernname and password
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String text=driver.findElement(By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']")).getText();
		System.out.println(text);
		driver.quit();
	
		

	}

}
