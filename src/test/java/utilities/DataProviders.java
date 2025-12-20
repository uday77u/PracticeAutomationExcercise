package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "excelData")
    public Object[][] getData() throws IOException {

        ExcellUtilityNew excel = new ExcellUtilityNew("./Data/UserData.xlsx");

        String sheetName = "TestData";

        int rows = excel.getRowCount(sheetName);
        int cols = excel.getCellCount(sheetName, 0);

        // Exclude header row → so rows-1
        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {          // Start from row 1
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = excel.getCellData(sheetName, i, j);
            }
        }

        return data;
    }
    
    @DataProvider(name = "InvalidLoginData")
    public Object[][] getInvalidLoginData() throws IOException {

        ExcellUtilityNew excel = new ExcellUtilityNew("./Data/UserData.xlsx");

        String sheet = "TestData";

        int rows = excel.getRowCount(sheet);
       // int cols = excel.getCellCount(sheet, 0);
        
        int cols = 3; // Email, Password, Expected

        Object[][] data = new Object[rows - 1][cols]; // excluding header

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = excel.getCellData(sheet, i, j);
            }
        }
        return data;
    }
    /*//DataProvider safety--DataProvider never returns null.
    @DataProvider(name = "loginData")
    public Object[][] getData() {

        Object[][] data = ExcelUtils.getTestData("Login");

        if (data == null || data.length == 0) {
            throw new RuntimeException("DataProvider returned no data");
        }
        return data;
    }
*/
    
}
