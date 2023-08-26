package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactInfoPage {
	//Declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement pageHeader;
		//initialization 
		public NewContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//utilization
		public String getHeader()
		{
		return pageHeader.getText();
		}

}
