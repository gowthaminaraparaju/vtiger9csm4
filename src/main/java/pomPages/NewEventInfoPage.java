package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEventInfoPage {
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	//initialization
	public NewEventInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	

	

}
