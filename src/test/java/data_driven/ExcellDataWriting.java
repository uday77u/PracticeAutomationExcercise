package data_driven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellDataWriting {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream("./Data\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		//XSSFRow row=sheet.createRow(4);  //5
		//XSSFCell cell=row.createCell(2); //3
		System.out.println("Enter data:");
		for(int r=0;r<=4;r++)
		{
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<2;c++) 
			{
				//Scanner sc=new Scanner(System.in);
				//XSSFCell cell=row.createCell(c);
				row.createCell(c).setCellValue(r+c);
			}
		}
		System.out.println("all data entered");
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
