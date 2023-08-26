package actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mine {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("C:\\Users\\gowthami\\OneDrive\\Desktop\\TestData.xlsx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet("Sheet1");
		int row=sheet.getLastRowNum();
		for(int i=1;i<=row;i++)
		{
			Row row1=sheet.getRow(i);
			System.out.println(row1.getCell(0).getStringCellValue());
			System.out.println(row1.getCell(1).getStringCellValue());
			
		}
		driver.quit();
		
	}

	}


