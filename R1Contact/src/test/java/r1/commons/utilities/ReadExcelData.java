package r1.commons.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	XSSFWorkbook wb;
	XSSFSheet exlSheet;
	
	public ReadExcelData(String fielpath)
	{
		  try {
			   File src=new File(fielpath);
			   FileInputStream fis=new FileInputStream(src);
			   wb=new XSSFWorkbook(fis);
			   
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		  		  
	}
	
	public List<String> getRowData(String sheetName,int row)
	{
		List<String> exlRowDataList=new ArrayList<String>();
		
		exlSheet=wb.getSheet(sheetName);
		
		int maxCell=  exlSheet.getRow(row).getLastCellNum();
		System.out.println("Last col number " + maxCell);
		
		for(int i=0;i<maxCell;i++)
		{
			exlRowDataList.add(exlSheet.getRow(row).getCell(i).getStringCellValue());

		}
		return exlRowDataList;
	}

}
