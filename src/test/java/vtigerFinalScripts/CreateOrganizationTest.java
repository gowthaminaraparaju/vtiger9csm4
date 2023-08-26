package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;
import genericliraries.IConstantPath;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrgTest()
	{
		SoftAssert soft=new SoftAssert();
		home.ClickOrganizations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		Map<String,String> map=excel.readFromExcel("OrganizationTestData", "Create Organization");
		String orgName =map.get("OrganizationName")+jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.clickSaveButton();
		soft.assertTrue(newOrgInfo.getHeader().contains(orgName));
		if(newOrgInfo.getHeader().contains(orgName))
		  excel.writetoExcel("OrganizationTestData", "Create Organization", "pass", IConstantPath.EXCEL_PATH);
		else
			excel.writetoExcel("OrganizationTestData", "Create Organization", "fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	
		
	}
	

}
