/*
 * Test Case 18: View Category Products
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that categories are visible on left side bar
4. Click on 'Women' category
5. Click on any category link under 'Women' category, for example: Dress
6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
7. On left side bar, click on any sub-category link of 'Men' category
8. Verify that user is navigated to that category page
 */
package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC018_ViewCategoryProducts extends BaseClass {
	HomePage Home=new HomePage(driver);
	@Test
	public void testViewCategoryProducts() throws InterruptedException {
		// Step 1-2: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\nStep 1-3: Navigate to home page and verified", true);
        
        //step 3:Verify that categories are visible on left side bar
        //----error webelement is null
        
       //dragToViewWebElement(driver, Home.LocatorHomePageFooter());
      /* JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();", Home.LocatorHomePageFooter());
       Thread.sleep(3000);
       Reporter.log("draged");*/
       
       
        
	}
}
