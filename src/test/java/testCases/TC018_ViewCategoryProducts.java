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
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC018_ViewCategoryProducts extends BaseClass {
	
	@Test
	public void testViewCategoryProducts() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		
		// Step 1-2: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\nStep 1-3: Navigate to home page and verified", true);
        
        //step 3:Verify that categories are visible on left side bar
        //----error webelement is null
        
       //dragToViewWebElement(driver, Home.LocatorHomePageFooter());
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();", homePage.LocatorCategories());
       Thread.sleep(3000);
       Reporter.log("draged",true);
       
        //step 4-5: Click on 'Women' category,Click on any category link under 'Women' category, for example: Dress 
        //step 6:Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        homePage.clickBtnWomenCategories();
        homePage.clickBtnDressSubWomenCategories();
        frameFindingForWebelement();
        driver.switchTo().frame(6);
        waitForVisibilityOfWebelement(homePage.LocatorMessageDressOnPage());
        assertTrue(homePage.isMessageDressOnPage(),"'Dress' is not displayed on page,unable to navigate 'Dress categories page'.");
        Reporter.log("Verified that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS",true);
        driver.switchTo().defaultContent();
        
        //step 7: On left side bar, click on any sub-category link of 'Men' category, 
        //step 8:Verify that user is navigated to that category page
        homePage.clickBtnMenCategories();
        homePage.clickBtnJeansSubMenCategories();
        waitForVisibilityOfWebelement(homePage.LocatorMessageJeansOnPage());
        assertTrue(homePage.isMessageJeansOnPage(),"\"'Jeans' is not displayed on page,unable to navigate 'Jeans categories page'.");
        Reporter.log("Verified that category page is displayed and confirm text 'MEN - JEANS PRODUCTS",true);

        
	}
	
	//utility to find frame of element
	public void frameFindingForWebelement() {
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Total iframes: " + iframes.size());

		for (int i = 0; i < iframes.size(); i++) {
		    driver.switchTo().defaultContent(); // reset frame context
		    driver.switchTo().frame(i);
		    
		    List<WebElement> targetElements = driver.findElements(By.xpath("//*[contains(text(),'Dress')]"));
		    
		    if (!targetElements.isEmpty()) {
		        System.out.println("Found 'Dress' text in iframe index: " + i);
		        break; // stop if found
		    }
		}

	}
	
}
