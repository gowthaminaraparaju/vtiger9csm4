package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1 convert physical file to java readable file
				FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");//xlsheet right click->properties>cl;ick on properties copy the path from src
				//open workbook
				Workbook workbook=WorkbookFactory.create(fis);
				//step 3 get control over sheet
				Sheet sheet=workbook.getSheet("Sheet1");
				//create new row
				Row row=sheet.createRow(4);
				//create new cell
				Cell cell=row.createCell(1);
				//set data into cell
				cell.setCellValue("trainee");
				//step 7 save data to excell
				FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
				workbook.write(fos);
				//close
				workbook.close();
	}
}
