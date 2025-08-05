package utilities;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcellUtilities {
    private String path;
    
    public ExcellUtilities(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            return (sheet != null) ? sheet.getLastRowNum() + 1 : 0;
        }
    }

    public int getCellCount(String sheetName) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                XSSFRow row = sheet.getRow(0);
                return (row != null) ? row.getLastCellNum() : 0;
            }
            return 0;
        }
    }

    public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                XSSFRow row = sheet.getRow(rowNum);
                if (row != null) {
                    XSSFCell cell = row.getCell(cellNum);
                    if (cell != null) {
                        return cell.toString();
                    }
                }
            }
            return "-";
        }
    }

    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        fi.close();

        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null)
            sheet = workbook.createSheet(sheetName);

        XSSFRow row = sheet.getRow(rowNum);
        if (row == null)
            row = sheet.createRow(rowNum);

        XSSFCell cell = row.getCell(colNum);
        if (cell == null)
            cell = row.createCell(colNum);

        cell.setCellValue(data);

        try (FileOutputStream fo = new FileOutputStream(path)) {
            workbook.write(fo);
        }
        workbook.close();
    }

    public void enterUserDataInExcel(String data) throws IOException {
        String sheetName = "Sheet1";
        int r = getRowCount(sheetName);
        int c = getCellCount(sheetName);
        setCellData(sheetName, r, c, data);
    }

    public static void main(String[] args) throws IOException {
        ExcellUtilities xl = new ExcellUtilities("./Data/TestData.xlsx");
        xl.enterUserDataInExcel("bye");
        System.out.println("data entered");
    }
}
