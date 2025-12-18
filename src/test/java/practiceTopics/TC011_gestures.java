package practiceTopics;

import org.testng.annotations.Test;

public class TC011_gestures extends BaseTest {
	@Test
	public void gestures() throws InterruptedException {
		try {
			logger.debug("Started Logging");
			logger.info("starting *** ***");
			
			HomePage homepage = new HomePage(driver);
			GesturesPage GesturesPage=new GesturesPage(driver);
			
			homepage.clickGesturesLink();
			System.out.println("Step 1: Click on the GuestureLink");
			
			GesturesPage.DragMoveMeHeader();
			System.out.println("Step 2: Draged the header");
			
			Thread.sleep(5000);
			
			GesturesPage.DragAndDropFromLeftToRightBox();
			System.out.println("Step 3: Draged AndDrop From LeftToRightBox");
			Thread.sleep(5000);

			
			GesturesPage.DragAndDropFromRightToLeftBox();
			System.out.println("Step 4: Draged and Drop FromRightToLeftBox");
			Thread.sleep(5000);
			
			
			
			
			
			
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished ***  ***");
			
		

	}
	
}
