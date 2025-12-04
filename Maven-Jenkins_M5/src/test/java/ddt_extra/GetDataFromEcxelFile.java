package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromEcxelFile {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//1. Get the Java Representation Object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptDataM5.xlsx");
		
		//2. Get the access of workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//3. Get the access of sheet
		Sheet sh = wb.getSheet("S.NAME");
		
		//4. Get the access of row 
		Row row = sh.getRow(1);
		
		//5. Get the access of cell
		Cell cell = row.getCell(0);
		
		//6. Get the data
		String data = cell.getStringCellValue();
		//cell.getNumericCellValue();
		//cell.getBooleanCellValue();
	    
		System.out.println(data);
		
		wb.close();
		
		
	}
	
	

}
