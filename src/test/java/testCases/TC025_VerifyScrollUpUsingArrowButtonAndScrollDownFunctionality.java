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

import org.openqa.selenium.JavascriptExecutor;
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
		HomePage homePage=new HomePage(driver);
		
		// Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, true);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\nNavigate to home page and verified", true);
        
        //step 4-5: Scroll down page to bottom, Verify 'SUBSCRIPTION' is visible
        scrollDownPageToBottom();
        Thread.sleep(3000);
        assertTrue(homePage.msgSubscription(), "'SUBSCRIPTION' is not visible");
        Reporter.log("Verified 'SUBSCRIPTION' is visible",true);
        Thread.sleep(3000);
        //step 6-7: Click on arrow at bottom right side to move upward
        //Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        homePage.clickScrollUpArrow();
        waitForVisibilityOfWebelement(homePage.LocatorMsgFullFledged());
        assertTrue(homePage.isMsgFullFledgedDisplayed(), "'Full-Fledged' text messge not visible");
        
        Reporter.log("Verified that page is scrolled up and '"+homePage.getMsgFullFledged()+"' text is visible on screen\n", true);
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
