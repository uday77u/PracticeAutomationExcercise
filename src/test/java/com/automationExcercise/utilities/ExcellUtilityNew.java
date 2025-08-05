package com.automationExcercise.utilities;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcellUtilityNew {

    private String filePath;
    private XSSFWorkbook workbook;
    private FileInputStream fis;
    private FileOutputStream fos;

    public ExcellUtilityNew(String filePath) {
        this.filePath = filePath;
    }

    // Load the workbook from the file or create it if it doesn't exist
    private void openWorkbook() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            workbook = new XSSFWorkbook();
            fos = new FileOutputStream(file);
            workbook.write(fos);
            workbook.close();
            fos.close();
        }
        fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
    }

    // Save and close the workbook
    private void saveAndCloseWorkbook() throws IOException {
        fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }

    // Get the number of (non-empty) rows in a sheet
    public int getRowCount(String sheetName) throws IOException {
        openWorkbook();
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = (sheet != null) ? sheet.getLastRowNum() + 1 : 0;
        workbook.close();
        fis.close();
        return rowCount;
    }

    // Get number of cells in a row
    public int getCellCount(String sheetName, int rowIndex) throws IOException {
        openWorkbook();
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = (sheet != null) ? sheet.getRow(rowIndex) : null;
        int cellCount = (row != null) ? row.getLastCellNum() : 0;
        workbook.close();
        fis.close();
        return cellCount;
    }

    // Get cell value at specified row and column
    public String getCellData(String sheetName, int rowIndex, int colIndex) throws IOException {
        openWorkbook();
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = (sheet != null) ? sheet.getRow(rowIndex) : null;
        Cell cell = (row != null) ? row.getCell(colIndex) : null;

        String cellData;
        try {
            DataFormatter formatter = new DataFormatter();
            cellData = (cell != null) ? formatter.formatCellValue(cell) : "";
        } catch (Exception e) {
            cellData = "";
        }

        workbook.close();
        fis.close();
        return cellData;
    }

    // Set cell data at specific row and column
    public void setCellData(String sheetName, int rowIndex, int colIndex, String data) throws IOException {
        openWorkbook();

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null)
            sheet = workbook.createSheet(sheetName);

        Row row = sheet.getRow(rowIndex);
        if (row == null)
            row = sheet.createRow(rowIndex);

        Cell cell = row.getCell(colIndex);
        if (cell == null)
            cell = row.createCell(colIndex);

        cell.setCellValue(data);
        saveAndCloseWorkbook();
    }

    // Append a value in the first empty row in a specific column
    public void setCellDataInNextEmptyRow(String sheetName, int colIndex, String data) throws IOException {
        openWorkbook();

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null)
            sheet = workbook.createSheet(sheetName);

        int nextRowIndex = getNextEmptyRowIndex(sheet);
        Row row = sheet.createRow(nextRowIndex);
        Cell cell = row.createCell(colIndex);
        cell.setCellValue(data);

        saveAndCloseWorkbook();
    }

    // Append a full row of values to the first truly empty row
    public void appendRow(String sheetName, String[] rowData) throws IOException {
        openWorkbook();

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null)
            sheet = workbook.createSheet(sheetName);

        int nextRowIndex = getNextEmptyRowIndex(sheet);
        Row row = sheet.createRow(nextRowIndex);

        for (int col = 0; col < rowData.length; col++) {
            Cell cell = row.createCell(col);
            cell.setCellValue(rowData[col]);
        }

        saveAndCloseWorkbook();
    }

    // Find the first truly empty row
    private int getNextEmptyRowIndex(Sheet sheet) {
        int rowIndex = 0;
        while (true) {
            Row row = sheet.getRow(rowIndex);
            if (row == null || isRowEmpty(row)) {
                return rowIndex;
            }
            rowIndex++;
        }
    }

    // Check if a row is empty
    private boolean isRowEmpty(Row row) {
        if (row == null)
            return true;
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    // Optional: Write headers if sheet is new
    public void writeHeadersIfMissing(String sheetName, String[] headers) throws IOException {
        openWorkbook();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null || sheet.getRow(0) == null) {
            if (sheet == null) sheet = workbook.createSheet(sheetName);
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }
        }
        saveAndCloseWorkbook();
    }

    // Demo
    public static void main(String[] args) {
        try {
            ExcellUtilityNew excel = new ExcellUtilityNew("./Data/UserData.xlsx");

            // Optional: Add headers if needed
            String[] headers = {"Name", "Role", "Email"};
            excel.writeHeadersIfMissing("TestData", headers);

            // Append user info
            String[] user1 = {"Alice", "QA Engineer", "alice@example.com"};
            String[] user2 = {"Bob", "DevOps", "bob@example.com"};

            excel.appendRow("TestData", user1);
            excel.appendRow("TestData", user2);

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
