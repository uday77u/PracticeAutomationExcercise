package practiceTopics;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC007_Tables extends BaseTest {
    
    @Test
    public void table() {
    	try {
    		logger.debug("Started Logging");
    		logger.info("starting *** TC007_Tables***");
    		
    		HomePage homePage = new HomePage(driver);
            TablesPage tablesPage = new TablesPage(driver);

            homePage.clickTablesLink();
            System.out.println("Step 1: click on the tablesLink");

            // Locate the table element
            WebElement table = driver.findElement(By.cssSelector("table"));

            // Get all data rows (tbody > tr)
            List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));

            System.out.println("Step 2: Total rows found: " + rows.size());

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));

                // ✅ Skip rows that don’t have all 3 cells
                if (cells.size() < 3) {
                    System.out.println("Skipping row (not enough columns): " + row.getText());
                    continue;
                }

                String rank = cells.get(0).getText();
                String country = cells.get(1).getText();
                String population = cells.get(2).getText();

                System.out.println(rank + " | " + country + " | " + population);
            }
    		}
    		catch (AssertionError ae) {
    		logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
    		throw ae;
    		}

    		logger.debug("Application logging ends");
    		logger.info("Finished *** TC007_Tables ***");
    		
        
    }
}
