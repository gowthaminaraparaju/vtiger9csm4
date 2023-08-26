package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;

public class CreateContactWithOrgTest extends BaseClass{
	@Test
	public void createContactWithOrgTest()
	{
	SoftAssert soft=new SoftAssert();
	home.ClickContacts();
    soft.assertTrue(driver.getTitle().contains("Contacts"));
    contacts.clickPlusButton();
    soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
	Map<String,String> map=excel.readFromExcel("ContactTestdata", "CreateContactwithOrganization");
	String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
	createContact.setLastName(lastName);
	createContact.selectExistingOrg(web, map.get("organizationName"));
	createContact.clickSaveButton();
	soft.assertTrue(newContactInfo.getHeader().contains(lastName));
	if(newContactInfo.getHeader().contains(lastName))
		excel.writetoExcel("ContactTestdata", "CreateContactwithOrganization", "pass", "LastName");
	else
		excel.writetoExcel("ContactTestdata", "CreateContactwithOrganization", "fail", "LastName");
	soft.assertAll();
		
	

}
}
