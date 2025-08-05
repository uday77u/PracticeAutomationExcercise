package data_driven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellDataReading {

	public static void main(String[] args) throws IOException {
	FileInputStream file=new FileInputStream("C:\\Users\\Udayashankar\\Desktop\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int totalRow = sheet.getLastRowNum();
		int totalCell=sheet.getRow(0).getLastCellNum();
		System.out.println("Total rows:"+totalRow+"\nTotal Cells:"+totalCell+"\n");
		
		for(int r=0;r<=totalRow;r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0;c<totalCell;c++)
			{
				XSSFCell Cell = currentRow.getCell(c); 
				System.out.print("\t"+Cell.toString());
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	
	}
}
