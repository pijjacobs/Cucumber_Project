package dataDriven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateExcelFileEx1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// creating an instance of Workbook class
//		Workbook wb = new HSSFWorkbook();
//		// creates an excel file at the specified location
//		OutputStream fileOut = new FileOutputStream("D:\\Jegan\\created excel\\EmployeeDetails.xlsx");
//		System.out.println("Excel File has been created successfully.");
//		wb.write(fileOut);
	
	try   
	{  
	String filename = "D:\\Jegan\\created excel\\CustomerDetails.xlsx";  
	FileOutputStream fileOut = new FileOutputStream(filename);  
	fileOut.close();  
	System.out.println("Excel file has been generated successfully.");  
	}   
	catch (Exception e)   
	{  
	e.printStackTrace();  
	}  
	}  
}
