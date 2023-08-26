package genericliraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class contains all reusable methods to perform driver related operations
 * @author gowthami
 *
 */
public class WebDriverUtility {
	private WebDriver driver;
	private WebDriverWait wait;
	/**
	 * this method is used to launch specified browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
	switch(browser)
	{
	case "Chrome":
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		break;
	case "firefox":
		driver=new FirefoxDriver();
		break;
	case "edge":
		driver=new EdgeDriver();
		break;
	default:
		System.out.println("invalid browser info");
	}
			
		
	
	return driver;
	
}
/**
 * this method is used to maximize the browser
 */
public void maximizeBrowser()
{
	driver.manage().window().maximize();
}
/**
 * this method is used to navigate to a application
 * @param url
 */
public void navigateToApp(String url)
{
	driver.get(url);
}
/**
 * this method is used to wait untill til the element is found
 * @param time
 */
	public void waitTillElementFound(long time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	/**
	 * this mis used to wait until the title contains
	 * @param title
	 * @param time
	 * @return
	 */
	public boolean explicitlyWait(String title, long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this is used to wait until the element is enable to visible
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitlyWait(WebElement element, long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to wait until the element is to clickable
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitlyWait(By element, long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method is used to move  to element
	 * @param element
	 */
	public void mouseOver(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * this method is used to rightClick on element
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
		
	}
	/**
	 * this method is used to double click on element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * this method is used to drag and drop an element to the target
	 * @param target
	 * @param element
	 */
	public void dragAndDrop(WebElement target, WebElement element)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	/**
	 * this method is used to select an element from dropdoown based on index
	 * @param element
	 * @param index
	 */
	public void selectFromDropdown(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this is used to select an element from dropdown based on value attribute
	 * @param element
	 * @param value
	 */
	public void selectFromDropdown(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
		
	}
	/**this is used to select an element from dropdown based on visibletext
	 * @param visibleText 
	 * @param element 
	 */
	public void selectFromDropdown(String visibleText, WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * this method is used to switch the control to frame based on index
	 * @param index
	 */
	public void switctToFrame(String index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to switch the control to frame based on frameid or name
	 * @param frameElement 
	 */
	public void switchToFrame(String frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * this method is used to switch back from frame to main webpage
	 */
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to take screenshot of the webpage and generates image file
	 * @param className
	 * @param jUtil
	 * @return 
	 */
	public String takeScreenshot(String className, JavaUtility jUtil)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/"+className+"_"+jUtil.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
		
	}
	/**
	 * this method is used to take screenshot of the webpage and generates base64 image
	 * @param driver 
	 * @param sjutil 
	 * @param string 
	 * @return
	 */
	
	public String takeScreenshot(String string, JavaUtility sjutil, WebDriver driver)
	{
		TakesScreenshot  ts=(TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * this method is used to scroll till the specified webelement 
	 * @param element
	 */
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 * this method handles alert popup
	 * @param status
	 */
	public void handleAlert(String status)
	{
		Alert alert=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			alert.accept();
		else
			alert.dismiss();
	}
	/**
	 * this method is used to switch to child Browser
	 */
	public void switchToChildWindow()
	{
		Set<String> set=driver.getWindowHandles();
		for(String window:set)
		{
			driver.switchTo().window(window);
		}
	}
	/**
	 * this method is used to switch the specified window
	 * @param WindowID
	 */
	public void switchToWindow(String WindowID)
	{
		driver.switchTo().window(WindowID);
	}
	/**
	 * this method is used to get the parent window address
	 * @return
	 */
	public String getParentWindowID()
	{
		return driver.getWindowHandle();
	}
	/**
	 * this method is used to close the current window
	 */
	public void closeCurrentWindow()
	{
		driver.close();
	}
	/**
	 * this method is used to quit all the windows
	 */
	public void quitAllWindows()
	{
		driver.quit();
	}
	/**
	 * this method is used to convert String to dynamic xpath
	 * @param commonPath
	 * @param replaceData
	 * @return
	 */
	public WebElement convertStringToDynamicXpath(String commonPath, String replaceData)
	{
		String requiredPath=String.format(commonPath, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}
	/**
	 * this method is used to convert string to dynamic xpath
	 * @param commonpath
	 * @param replaceData
	 * @return
	 */
	public WebElement convertStringToDynamicXpath(String commonpath, int replaceData)
	{
		String requiredPath=String.format(commonpath, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}

}



