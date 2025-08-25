/*
 * Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
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
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC025_VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality extends BaseClass{
	@Test
	public void testVerifyScrollUpUsingArrowButtonAndScrollDownFunctionality() throws InterruptedException {
		try {
		HomePage homePage=new HomePage(driver);
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
		logger.info("starting TC025_VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality");

		// Step 1-3: Navigate to home page and  Verify that home page is visible successfully
		logger.info("Step 1: Launching the browser");
		logger.info("Step 2: Navigating to baseURL: " + baseURL);
		driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
		
        
        
        
        
        
        //step 4-5: Scroll down page to bottom, Verify 'SUBSCRIPTION' is visible
        logger.info("4. Scroll down page to bottom");
        scrollDownPageToBottom();
        Thread.sleep(3000);
        
        logger.info("5. Verify 'SUBSCRIPTION' is visible");
        assertTrue(homePage.msgSubscription(), "'SUBSCRIPTION' is not visible");
        Reporter.log("Verified 'SUBSCRIPTION' is visible",true);
        Thread.sleep(3000);
        
        //step 6-7: Click on arrow at bottom right side to move upward
        //Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        logger.info("6. Click on arrow at bottom right side to move upward");
        homePage.clickScrollUpArrow();
        
        logger.info("7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        waitForVisibilityOfWebelement(homePage.LocatorMsgFullFledged());
        assertTrue(homePage.isMsgFullFledgedDisplayed(), "'Full-Fledged' text messge not visible");
        
        Reporter.log("Verified that page is scrolled up and '"+homePage.getMsgFullFledged()+"' text is visible on screen", true);
        
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in testVerifyScrollUpUsingArrowButtonAndScrollDownFunctionality: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in testVerifyScrollUpUsingArrowButtonAndScrollDownFunctionality: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
        logger.debug("application logs end.......");
    	logger.info("**** finished TC025_VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality  *****"); 
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
	
}
