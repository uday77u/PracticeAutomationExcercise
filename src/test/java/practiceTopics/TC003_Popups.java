package practiceTopics;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC003_Popups extends BaseTest {
	@Test
	public void popups() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		PopupsPage popupsPage=new PopupsPage(driver);
		Reporter.log("TC003_Popups",true);

		
		homePage.clickPopupsLink();
		assertTrue(driver.getCurrentUrl().contains("popups"), "'Popups'Page is not opened");
		Reporter.log("clicked PopupLink",true);
		
		popupsPage.clickAlertPopup();
		Reporter.log("clicked Alert Popup",true);
		
		driver.switchTo().alert().accept();
		Reporter.log("clicked alert accepted",true);
		
		popupsPage.clickConfirmPopup();
		Reporter.log("clicked Submit Button",true);
		
		driver.switchTo().alert().accept();
		Reporter.log("clicked Confirm Popup 'ok'",true);
		
		popupsPage.clickConfirmPopup();
		driver.switchTo().alert().dismiss();
		Reporter.log("clicked Confirm Popup 'Cancel'",true);
		
		popupsPage.clickPromptPopup();
		Reporter.log("clicked Prompt Popup",true);

		driver.switchTo().alert().sendKeys("Good morning");
		driver.switchTo().alert().accept();
		Reporter.log("Enter 'popup' message field and clicked accept",true);
		
		popupsPage.clickPromptPopup();
		driver.switchTo().alert().dismiss();
		Reporter.log("clicked Prompt Popup 'Cancel'",true);
		
		popupsPage.clickmyTooltip();
		Thread.sleep(8000);
		Reporter.log("clicked Tooltip",true);
		Reporter.log(popupsPage.myTooltip.getTagName());
		
		Reporter.log("Tooltip message:- "+popupsPage.getTooltipMessage(),true);
		Thread.sleep(3000);
		

	}
	
}
