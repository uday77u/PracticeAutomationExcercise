package practiceTopics;

import org.testng.annotations.Test;

public class TC014_Spinners extends BaseTest{

	@Test
	public void Spinners() {
		
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC014_Spinners ***");
			
			HomePage homePage=new HomePage(driver);

			homePage.clickSpinnersLink();
			System.out.println("Step 1: clicked on SpinnersLink");
			
			
			
			
			
			
			
			
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished ***TC014_Spinners  ***");
			
		
		
		
	}
}
