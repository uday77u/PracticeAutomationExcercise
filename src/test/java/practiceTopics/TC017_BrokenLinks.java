package practiceTopics;

import org.testng.annotations.Test;

public class TC017_BrokenLinks extends BaseTest{

	@Test
	public void BrokenLinks() {
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC017_BrokenLinks ***");
			
			HomePage homePage=new HomePage(driver);
			BrokenImagesPage brokenImagesPage=new BrokenImagesPage(driver);
			
			homePage.clickBrokenLinksLink();
			System.out.println("Step 1: clicked on BrokenLinksLink");
			
			
			
			
			
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished ***TC017_BrokenLinks  ***");
			
		
	}
}
