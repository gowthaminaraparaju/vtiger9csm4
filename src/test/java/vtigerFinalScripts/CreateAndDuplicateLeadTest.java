package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;
import genericliraries.IConstantPath;

public class CreateAndDuplicateLeadTest extends BaseClass
{
	@Test
	public void createLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		Map<String,String> map=excel.readFromExcel("Leadstestdata", "CreateandduplicateLead");
		String lastName=map.get("LastName")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompanyName(map.get("Company"));
		createLead.cickSaveButton();
		soft.assertTrue(newLeadInfo.getHeader().contains(lastName));
		newLeadInfo.clickDuplicateButton();
		soft.assertTrue(duplicatingLead.getHeader().contains("Duplicating"));
		String newLastname=map.get("New Last Name")+jutil.generateRandomNum(100);
		duplicatingLead.setLastName(newLastname);
		duplicatingLead.clickSaveButton();
		if(newLeadInfo.getHeader().contains(lastName))
			excel.writetoExcel("Leadstestdata", "CreateandduplicateLead", "pass", IConstantPath.EXCEL_PATH);
		else
			excel.writetoExcel("Leadstestdata", "CreateandduplicateLead", "fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	}
}




