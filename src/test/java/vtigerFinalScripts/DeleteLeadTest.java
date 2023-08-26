package vtigerFinalScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;
import genericliraries.IConstantPath;

public class DeleteLeadTest extends BaseClass {
	@Test
	public void deleteLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		lead.traverseToRequiredLead(web, "Lead4");
		lead.clickDelete();
		web.handleAlert("ok");
		List<WebElement> leadsNameList=lead.getLeadNamesList();
		boolean status=false;
		for(WebElement leads:leadsNameList)
		{
			if(!(leads.getText().equals("Lead4")))
				status=true;
		}
		soft.assertTrue(status);
		if(status)
		
			excel.writetoExcel("LeadsTestData", "Delete Lead", "pass", IConstantPath.EXCEL_PATH);
		
		else
			excel.writetoExcel("LeadsTestData", "Delete Lead", "fail", IConstantPath.EXCEL_PATH);
		soft.assertTrue(status);
		soft.assertAll();
		
	}

}
