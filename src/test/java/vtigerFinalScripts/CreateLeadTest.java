package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;
import genericliraries.IConstantPath;

public class CreateLeadTest extends BaseClass{

	@Test
	public void createLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		Map<String,String> map=excel.readFromExcel("Leadstestdata", "CreateLead");
		
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		excel.writeToExcel("LeadsTestData", 7, 3, lastName,IConstantPath.EXCEL_PATH);
		createLead.setLastName(lastName);
		createLead.setCompanyName(map.get("Company"));
		createLead.cickSaveButton();
		soft.assertTrue(newLeadInfo.getHeader().contains(lastName));
		if(newLeadInfo.getHeader().contains(lastName))
			excel.writetoExcel("Leadstestdata", "CreateLead", "pass", IConstantPath.EXCEL_PATH);
		else
			excel.writetoExcel("Leadstestdata", "CreateLead", "fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	}

}
