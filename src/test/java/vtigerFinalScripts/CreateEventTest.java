package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericliraries.BaseClass;
import genericliraries.IConstantPath;

public  class CreateEventTest extends BaseClass{
	@Test
	public void createEventTest()
	{
		SoftAssert soft=new SoftAssert();
		Map<String,String> map=excel.readFromExcel("EventsTestData", "CreateNewEvent");
		home.selectFromQuickCreate(web, map.get("QuickCreate"));
		soft.assertEquals(createEvent.getPageHeader(), "Create To Do");
		String subject=map.get("subject")+jutil.generateRandomNum(100);
		createEvent.setSubject(subject);
		createEvent.clickOnStartDate();
		createEvent.chooseRequiredDate(web, map.get("StartDate"), jutil);
		createEvent.clickOnDueDate();
		createEvent.chooseRequiredDate(web, map.get("Duedate"), jutil);
		createEvent.clickSaveButton();
		soft.assertTrue(newEventInfo.getPageHeader().contains(subject));
		if(newEventInfo.getPageHeader().contains(subject))
			excel.writetoExcel("EventsTestData", "CreateNewEvent", "pass", IConstantPath.EXCEL_PATH);
		else
			excel.writetoExcel("EventsTestData", "CreateNewEvent", "fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	}

}
