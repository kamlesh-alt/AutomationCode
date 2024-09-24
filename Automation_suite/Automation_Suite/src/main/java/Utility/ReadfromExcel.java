package Utility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadfromExcel {

	
	String xlpath="./TestData/Data.xlsx";
	private String Sheet1="sheet1";
	private String Sheet2="Sheet2";
	
	public Object[][] getExcelDataFromsheet2() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] arrayexcelldata=null;
	try{
	
		int TotalNoOfRows=Data.getLastRow(xlpath, Sheet2)+1;
		int TotalNoOfColos=Data.getLastColumn(xlpath, Sheet2, 0);
		
		arrayexcelldata=new Object[TotalNoOfRows-1][TotalNoOfColos];
		for(int i=0;i<TotalNoOfRows;i++){
			for(int j=0;j<TotalNoOfColos;j++){
				arrayexcelldata[i-1][j]=Data.getCellValue(xlpath, Sheet2, i, j);
				
			}
			
			}
		
			
	}
	catch(FileNotFoundException e){
		e.getClass();
		}
	catch(IOException e){
		e.getMessage();
	}
		
		return arrayexcelldata;
		
		
	}public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		ReadfromExcel rd=new ReadfromExcel();
		rd.getExcelDataFromsheet2();
	}
	
}
	
	
	
	
