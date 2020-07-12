package excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_PrintInConsole {
public static void main(String args[]) throws Exception 
{
	File src = new File("C:\\eclipse\\testdata\\testdata.xlsx");
	FileInputStream fis = new FileInputStream(src);
	HSSFWorkbook wb1 = new HSSFWorkbook();   //For .xls
	XSSFWorkbook wb = new XSSFWorkbook(fis); //For .xlsx
	XSSFSheet sheet1 = wb.getSheetAt(0);
	String username1 = sheet1.getRow(0).getCell(0).getStringCellValue();
	System.out.println("The username is: " +username1);
	String password1 = sheet1.getRow(0).getCell(1).getStringCellValue();
	System.out.println("The password is: " +password1);
	System.out.println("********************************");
	
	int rowCount = sheet1.getLastRowNum();
	for(int i=0;i<=rowCount;i++) {
		String username = sheet1.getRow(i).getCell(0).getStringCellValue();
		System.out.println("The usernames are: " +username);
		for (int j=2;j<rowCount;j++) {
			String password = sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("The passwords are: " +password);			
		}
	}
	wb.close();
}
}