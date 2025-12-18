package practiceTopics;

import org.testng.annotations.Test;

public class TC016_BrokenImages extends BaseTest {

	@Test
	public void BrokenImages() {
		
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC016_BrokenImages ***");
			
			HomePage homePage=new HomePage(driver);
			BrokenImagesPage brokenImagesPage=new BrokenImagesPage(driver);
			
			homePage.clickBrokenImagesLink();
			System.out.println("Step 1: clicked on BrokenImagesLink");
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished *** TC016_BrokenImages ***");
			
		
		
	}
}
