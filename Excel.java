package util;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	Workbook book;
	public Excel(String fileName)
	{
		try {
			FileInputStream inFile=new FileInputStream(fileName);//filename was here
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
		data=null;
	}
	
	return data;
	}
	
	public int rowCount(String SheetName)
	{
		return book.getSheet(SheetName).getLastRowNum();
	}
	
	public int cellCount(String SheetName,int R)
	{
		Sheet sh=	book.getSheet(SheetName);
		int C=sh.getRow(R).getLastCellNum()-1;
		return C;
	}
	public Object[][] MyDataProvider(String sheet,int column) throws Exception
	{
		
		Sheet customSheet =book.getSheet(sheet);
		Object[][] data = new Object[customSheet.getLastRowNum()][column];
		for(int r=1;r<=customSheet.getLastRowNum();r++)
		{
			
			for(int c=0;c<column;c++)
			{
				String cellData=null;
					try
					{
						cellData=customSheet.getRow(r).getCell(c).toString();
						if(cellData.endsWith(".0"))
							cellData=cellData.split("\\.")[0];
							
					}
					catch(NullPointerException N)
					{
						cellData=null;
					}
					System.out.println(cellData);
					data[r-1][c]= cellData;
			}
		}
		
		return data;
		
		
	}

}
