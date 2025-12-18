package practiceTopics;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC001_javaScriptDelays extends BaseTest{
	@Test
	public void waitForLiftOffText() {
	
		try {
			logger.debug("Started Logging");
			logger.info("starting TC001_javaScriptDelays");
			
			HomePage homePage = new HomePage(driver);
			JavascriptDelaysPage javascriptDelaysPage = new JavascriptDelaysPage(driver);
			logger.info("TC001_javaScriptDelays",true);

			
			homePage.clickJavaScriptDelaysLink(driver);
			
			javascriptDelaysPage.clickStartButton(driver);
			logger.info("Step 1: Clicked on the 'Start' button");
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.textToBePresentInElement(javascriptDelaysPage.delayText, "Liftoff!"));
			
			assertTrue(javascriptDelaysPage.delayText.getText().contains("Liftoff"),"'Liftoff' is not present");
			logger.info("Step 2: Verified that 'Liftoff' is present");
			
		} catch (Exception e) {
			logger.error("Exception (waitForLiftOffText):"+e.getMessage());
			throw e;
		}
		catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
		}
		
		logger.debug("Application logging ends");
		logger.info("Finished *** TC001_javaScriptDelays ***");
	}

}
