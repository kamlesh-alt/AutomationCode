package Utility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class DatafromExcel {

	String xlpath="./TestData/Data.xlsx";
	private String sheet1="Sheet1";
	private String sheet2="Sheet2";
	private String sheet3="Sheet3";	
	
	public  Object[][] getExcelDatafromSheet1() throws EncryptedDocumentException, InvalidFormatException {
		
		Object[][] arrayExcelData = null;
		try {
		    int totalNoOfRows = Data.getLastRow(xlpath, sheet1)+1;
		    //System.out.println("The total Rows in Excel : "+totalNoOfRows);
			int totalNoOfCols = Data.getLastColumn(xlpath, sheet1, 0);
			//System.out.println("The total Column in Excel : "+totalNoOfCols);
			
			arrayExcelData = new Object[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i <totalNoOfRows; i++) 
			{
				for (int j=0; j < totalNoOfCols; j++) 
				{
					arrayExcelData[i-1][j] = Data.getCellValue(xlpath, sheet1, i, j);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		} 
		return arrayExcelData;
		
		
	}
	
	
	
public  Object[][] getExcelDatafromSheet2() throws EncryptedDocumentException, InvalidFormatException {
		
		Object[][] arrayExcelData = null;
		try {
		    int totalNoOfRows = Data.getLastRow(xlpath, sheet2)+1;
		    System.out.println("The total Rows in Excel : "+totalNoOfRows);
			int totalNoOfCols = Data.getLastColumn(xlpath, sheet2, 0);
			System.out.println("The total Column in Excel : "+totalNoOfCols);
			
			arrayExcelData = new Object[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i <totalNoOfRows; i++) 
			{
				for (int j=0; j < totalNoOfCols; j++) 
				{
					arrayExcelData[i-1][j] = Data.getCellValue(xlpath, sheet2, i, j);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		} 
		return arrayExcelData;
	}
	
}
