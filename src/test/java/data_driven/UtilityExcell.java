package data_driven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityExcell {
	public static int getRowCount(String filePath,String sheetName) throws IOException
	{
		FileInputStream file=new FileInputStream(filePath);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sh=wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}

	public static int getCoumnCount(String filePath,String sheetName) throws IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheetName);
		return sh.getRow(0).getLastCellNum();
		
	}
	
	public static String getCellData(String filePath,String sheetName,int row,int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(cell);
		try {
			String cellData = c.toString();
			return cellData;
		} catch (Exception e) {
			String cellData="";
			return cellData;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\Udayashankar\\Desktop\\TestData.xlsx";
		int r=getRowCount(filePath, "Sheet1");
		int c=getCoumnCount(filePath, "Sheet1");
		System.out.println("Row count:"+r+"\nColumn count:"+c);
		String d = getCellData(filePath, "Sheet1", r, c-1);
		System.out.println("Cell Data:"+d);

	}

}
