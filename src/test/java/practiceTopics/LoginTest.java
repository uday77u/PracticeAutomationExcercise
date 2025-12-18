package practiceTopics;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;
import utilities.ExcellUtilityNew;

public class LoginTest {

    @Test(dataProvider = "excelData", dataProviderClass = DataProviders.class)
    public void loginTest(String name, String role, String email) {

        System.out.println("------------ NEW TEST DATA ------------");
        System.out.println("Name  : " + name);
        System.out.println("Role  : " + role);
        System.out.println("Email : " + email);

        boolean status = false;

        try {

            // 👇 Here goes your REAL selenium code
            // Example logic (replace with real)
            if (email.contains("@")) {
                status = true;
            }

            Assert.assertTrue(status);

        } catch (Exception e) {
            status = false;
        }

        // Write result back to Excel (optional)
        try {
            ExcellUtilityNew excel = new ExcellUtilityNew("./Data/UserData.xlsx");

            int row = getRowNumber(name);
            excel.setCellData("TestData", row, 3, status ? "PASS" : "FAIL");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method: find row by Name
    public int getRowNumber(String name) {

        try {
            ExcellUtilityNew excel = new ExcellUtilityNew("./Data/UserData.xlsx");

            int rows = excel.getRowCount("TestData");

            for (int i = 1; i < rows; i++) {
                if (excel.getCellData("TestData", i, 0).equalsIgnoreCase(name)) {
                    return i;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }
}
