package practiceTopics;

import org.testng.annotations.Test;

public class TC009_Hover extends BaseTest{

	@Test
	public void Hover() throws InterruptedException {
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC009_Hover ***");
			HomePage homePage=new HomePage(driver);
			HoverPage hoverPage=new HoverPage(driver);
			
			homePage.clickHoverLink();
			System.out.println("Step 1: click on HoverLink");
			Thread.sleep(5000);
			
			System.out.println("Step 2: Before mouse hover:"+hoverPage.getMouseOverTabTxt());
			hoverPage.HoverMouseOverTab();
			System.out.println("Step 3: mouse HoverMouseOverTab");
			
			System.out.println("Step 4: After mouse hover:"+hoverPage.getMouseOverTabTxt());
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished ***TC009_Hover  ***");
			
		
	}
	
}
