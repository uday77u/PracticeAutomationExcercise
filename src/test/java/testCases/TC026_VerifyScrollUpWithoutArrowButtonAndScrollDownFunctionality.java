/*
 * Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Scroll up page to top
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC026_VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality extends BaseClass {
	@Test
	public void testVerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality() {
		logger.debug("application logs are started");
		logger.info("**** starting TC026 testVerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality***** ");
		try {
			
		HomePage homePage=new HomePage(driver);
		// Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        logger.info("Opened the application URL");
        Reporter.log("Navigating to baseURL: " + baseURL, true);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\nNavigate to home page and verified", true);
        logger.info("Home Page is displayed");
        
        //step 4-5: Scroll down page to bottom, Verify 'SUBSCRIPTION' is visible
        scrollDownPageToBottom();
        logger.info("Scroll down page to bottom");
        assertTrue(homePage.msgSubscription(), "'SUBSCRIPTION' is not visible");
        Reporter.log("Verified 'SUBSCRIPTION' is visible",true);
        logger.info("");
        //step 6-7: Scroll up page to top
        //Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        scrollUpPageToTop();
        waitForVisibilityOfWebelement(homePage.LocatorMsgFullFledged());
        assertTrue(homePage.isMsgFullFledgedDisplayed(), "'Full-Fledged' text messge not visible");
		
		
		
		
		}
		catch (Exception e) {
			logger.error("test failed..");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
        
		logger.debug("application logs end.......");
		logger.info("**** finished TC026_VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality  *****"); 
        
        
        
        
	}
	//scroll down 
		public void scrollDownPageToBottom() {
			Actions ac=new Actions(driver);
			ac.sendKeys(Keys.PAGE_DOWN).perform();;
			ac.sendKeys(Keys.END).perform();
		}
		
		//utility to wait for web element visibility
		public void waitForWebelementVisibility(WebElement webElement) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(webElement));
			
		}
		public void scrollUpPageToTop() {
			Actions ac=new Actions(driver);
			ac.sendKeys(Keys.PAGE_UP).perform();;
			ac.sendKeys(Keys.HOME).perform();
		}
	
}
