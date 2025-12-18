package practiceTopics;

import org.testng.annotations.Test;

public class TC015_Iframes extends BaseTest {

	@Test
	public void Iframes() {
		
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC015_Iframes ***");
			
			HomePage homePage=new HomePage(driver);
			IframesPage iframesPage=new IframesPage(driver);
			
			homePage.clickIframesLink();
			System.out.println("Step 1: clicked on IframesLink");
			
			iframesPage.clickGetStartedBtn();
			System.out.println("Step 2: clicked on GetStartedBtn");
			
			iframesPage.clickProjectsBtn();
			System.out.println("Step 3: clicked on ProjectsBtn");
			
			
			
			
			
			
			
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished *** TC015_Iframes ***");
			
		
		
		
	}
}
