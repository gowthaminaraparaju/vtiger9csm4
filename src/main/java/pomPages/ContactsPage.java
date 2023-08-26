package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement plusButton;
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void clickPlusButton() 
	{
		plusButton.click();
	}

}
