package practiceTopics;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class TC003_Popups extends BaseTest {
	@Test
	public void popups() throws InterruptedException {
		try {
			HomePage homePage=new HomePage(driver);
			PopupsPage popupsPage=new PopupsPage(driver);
			logger.info("TC003_Popups",true);

			
			homePage.clickPopupsLink();
			assertTrue(driver.getCurrentUrl().contains("popups"), "'Popups'Page is not opened");
			logger.info("Step 1: clicked PopupLink",true);
			
			popupsPage.clickAlertPopup();
			logger.info("Step 2: clicked Alert Popup",true);
			
			driver.switchTo().alert().accept();
			logger.info("Step 3: clicked alert accepted",true);
			
			popupsPage.clickConfirmPopup();
			logger.info("Step 4: clicked Submit Button",true);
			
			driver.switchTo().alert().accept();
			logger.info("Step 5: clicked Confirm Popup 'ok'",true);
			
			popupsPage.clickConfirmPopup();
			driver.switchTo().alert().dismiss();
			logger.info("Step 6: clicked Confirm Popup 'Cancel'",true);
			
			popupsPage.clickPromptPopup();
			logger.info("Step 7: clicked Prompt Popup",true);

			driver.switchTo().alert().sendKeys("Good morning");
			driver.switchTo().alert().accept();
			logger.info("Step 8: Enter 'popup' message field and clicked accept",true);
			
			popupsPage.clickPromptPopup();
			driver.switchTo().alert().dismiss();
			logger.info("Step 9: clicked Prompt Popup 'Cancel'",true);
			
			popupsPage.clickmyTooltip();
			Thread.sleep(8000);
			logger.info("Step 10: clicked Tooltip",true);
			logger.info(popupsPage.myTooltip.getTagName());
			
			logger.info("Step 11: Tooltip message:- "+popupsPage.getTooltipMessage(),true);
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
			throw e;
		}
		catch (AssertionError ae) {
			logger.error("AssertionError: "+ae.getMessage());
			throw ae;
		}
		
		

	}
	
}
