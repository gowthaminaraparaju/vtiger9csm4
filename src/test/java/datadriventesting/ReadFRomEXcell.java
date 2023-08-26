package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadFRomEXcell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1 convert physical file to java readable file
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");//xlsheet right click->properties>cl;ick on properties copy the path from src
		//open workbook
		Workbook workbook=WorkbookFactory.create(fis);
		//step 3 get control over sheet
		Sheet sheet=workbook.getSheet("Sheet1");//go to xl sheet and open with-->system editor-->click on ss model.
        //step 4 get control over row
		Row row=sheet.getRow(1);
		Row row2=sheet.getRow(3);
		//step 5 get control over cell
		Cell cell=row.getCell(1);
		Cell cell2=row2.getCell(1);
		int m=sheet.getLastRowNum();
		int n=row.getLastCellNum();
		for( m=0;m<=3;m++)
		{
			System.out.println(sheet.getRow(m));
			
			
		}
		//step 6 fetch data
		System.out.println(cell.getStringCellValue());
		System.out.println(cell2.getNumericCellValue());
		//step close workbook
		workbook.close();
	}

}
