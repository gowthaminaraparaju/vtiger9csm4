package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericliraries.WebDriverUtility;

public class HomePage {
	//Declaration
	@FindBy(xpath="//a[text()='Leads' and contains(@href,'action=index')]")
	private WebElement LeadsTab;
	@FindBy(xpath="//a[text()='Contacts' and contains(@href,'action=index')]")
	private WebElement ContactsTab;
	@FindBy(xpath="//a[text()='Organizations' and contains(@href,'action=index')]")
	private WebElement OrganizationsTab;
	@FindBy(id="qccombo")
	private WebElement quickCreateDropdown;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminicon;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutButton;
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void clickLeads()
	{
		LeadsTab.click();
	}
	public void ClickContacts()
	{
		ContactsTab.click();
	}
	public void ClickOrganizations()
	{
		OrganizationsTab.click();
	}
	public void selectFromQuickCreate(WebDriverUtility web, String value)
	{
		web.selectFromDropdown(quickCreateDropdown, value);
	}
	public void signOutOfVtiger(WebDriverUtility web)
	{
		web.mouseOver(adminicon);
		signOutButton.click();
		
	}

	

}
