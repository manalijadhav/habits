package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcel
{
	Workbook book;
	public DataDrivenExcel(String fileName)
	{
		try {
			FileInputStream inFile=new FileInputStream(fileName);
			if(fileName.endsWith(".xls"))
			{
				book=new HSSFWorkbook(inFile);
			}
			else if(fileName.endsWith(".xlsx"))
			{
				 book=new XSSFWorkbook(inFile);
			}
		} catch (Exception e) 
		{
			System.out.println("Error with File Reading");
		}
	}
	public String Read(String SheetName, int R,int C)
	{
	Sheet sh=	book.getSheet(SheetName);
	String data=null;
	try {
		data = sh.getRow(R).getCell(C).toString();
		if(data.endsWith(".0"))	
		data=data.split("\\.")[0];
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return data;
	}
	
	public int rowCount(String SheetName)
	{
		return book.getSheet(SheetName).getLastRowNum()+1;
	}
	
	public int cellCount(String SheetName,int R)
	{
		Sheet sh=	book.getSheet(SheetName);
		int C=sh.getRow(R).getLastCellNum();
		return C;
	}
}
