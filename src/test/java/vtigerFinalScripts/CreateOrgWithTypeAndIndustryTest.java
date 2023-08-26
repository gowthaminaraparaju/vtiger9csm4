package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;

public class CreateOrgWithTypeAndIndustryTest extends BaseClass{
	@Test
	public void createOrgWithindustryAndTypeTest()
	{
		SoftAssert soft=new SoftAssert();
		home.ClickOrganizations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		Map<String,String> map=excel.readFromExcel("OrganizationTestData", "Create Organization");
		String orgName =map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.clickSaveButton();
		soft.assertTrue(newOrgInfo.getHeader().contains(orgName));
		if(newOrgInfo.getHeader().contains(orgName))
			excel.writetoExcel("OrganizationTestData", "CreateOrganizationWithIndustryandType", "pass", "IConstantPath.EXCEL_PATH");
		else
			excel.writetoExcel("OrganizationTestData", "CreateOrganizationWithIndustryandType", "fail", "IConstantPath.EXCEL_PATH");
		soft.assertAll();
	}
}


