	package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.WebElement;


public class Data
{
	public static String getCellValue(String xlpath,String sheet,int row,int col) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		String s="";
		
			FileInputStream fis=new FileInputStream(xlpath);
			Workbook wb=WorkbookFactory.create(fis);
			try{
			 s = wb.getSheet(sheet).getRow(row).getCell(col).toString();
           }catch(NullPointerException e){
        	   System.out.println(e.getMessage());
           }
		return s;
	}
	public static int getLastRow(String xlpath,String sheet) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		FileInputStream fis=new FileInputStream(xlpath);
		Workbook wb=WorkbookFactory.create(fis);
		int total = wb.getSheet(sheet).getLastRowNum();
		return total;
	}
	public static int getLastColumn(String xlpath,String sheet,int row) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		FileInputStream fis=new FileInputStream(xlpath);
		Workbook wb=WorkbookFactory.create(fis);
		int colnum = wb.getSheet(sheet).getRow(row).getLastCellNum();
		
		return colnum;
	}
	public static void setCellValue(String xlpath, String sheet,int row,int cel, String value) throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		FileInputStream fis = new FileInputStream(xlpath);
        Workbook wb = WorkbookFactory.create(fis);
        CellStyle style =wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    try
    {
    	
    	Sheet sht =wb.getSheet(sheet);
    	
    	Row r=  sht.getRow(row);
	    Cell cell1 = r.createCell(cel);
	    cell1.setCellType(CellType.STRING);
	    cell1.setCellValue(value);
	    
	    sht.autoSizeColumn(cel);
    	   
    	{
    				    
    	 }		    
    }
    
    catch(NullPointerException e)
    {
    	System.out.println("------------Null Value---------------"+e.getMessage());
    }
    finally
    {
	     FileOutputStream fos = new FileOutputStream(xlpath);
	     wb.write(fos);
	     fos.close();
	     wb.close();
    }
	}	
	
	
	public static void setCellValue1(String xlpath, String sheet,int row,int cel, String value) throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		FileInputStream fis = new FileInputStream(xlpath);
        Workbook wb = WorkbookFactory.create(fis);
        CellStyle style =wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    try
    {
    	
    	Sheet sht =wb.getSheet(sheet);
    	
    	Row r=  sht.createRow(row);
	    Cell cell1 = r.createCell(cel);
	    cell1.setCellType(CellType.STRING);
	    cell1.setCellValue(value);
	   
	    sht.autoSizeColumn(cel);
    	   
    	{
    				    
    	 }		    
    }
    
    catch(NullPointerException e)
    {
    	System.out.println("------------Null Value---------------"+e.getMessage());
    }
    finally
    {
	     FileOutputStream fos = new FileOutputStream(xlpath);
	     wb.write(fos);
	     fos.close();
	     wb.close();
    }
	}
	
	public static void deletecellvalue(String xlpath, String sheet,int row,int cel) throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		FileInputStream fis = new FileInputStream(xlpath);
        Workbook wb = WorkbookFactory.create(fis);
        
    try
    {
    	
    	Sheet sht =wb.getSheet(sheet);
    	
    	Row r=  sht.getRow(row);
	    Cell cell1 = r.getCell(cel);
	    cell1.setCellType(CellType.BLANK);
	    
    }
    
    catch(NullPointerException e)
    {
    	System.out.println("------------Null Value---------------"+e.getMessage());
    }
    finally
    {
	     FileOutputStream fos = new FileOutputStream(xlpath);
	     wb.write(fos);
	     fos.close();
	     wb.close();
    }
	}
}
