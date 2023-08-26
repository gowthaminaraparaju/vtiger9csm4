package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;

public class CreateContactTest extends BaseClass{
	@Test
	public void createContactTest()
	{
		SoftAssert soft=new SoftAssert();
		home.ClickContacts();
	    soft.assertTrue(driver.getTitle().contains("Contacts"));
	    contacts.clickPlusButton();
	    soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		Map<String,String> map=excel.readFromExcel("ContactTestdata", "CreateContact");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.clickSaveButton();
		soft.assertTrue(newContactInfo.getHeader().contains(lastName));
		if(newContactInfo.getHeader().contains(lastName))
			excel.writetoExcel("ContactTestdata", "CreateContact", "pass", "LastName");
		else
			excel.writetoExcel("ContactTestdata", "CreateContact", "pass", "LastName");
		soft.assertAll();
			
		
		
	}
	

}
