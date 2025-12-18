package practiceTopics;

import org.testng.annotations.Test;

public class TC004_Sliders extends BaseTest{
	@Test
	public void Sliders() throws InterruptedException {
		try {
			logger.debug("Started Logging");
			logger.info("starting TC004_Sliders");
			
			HomePage homePage=new HomePage(driver);
			SlidersPage slidersPage=new SlidersPage(driver);
			
			homePage.clickSlidersLink();
			logger.info("Step 1: clicked on SlidersLink");
			Thread.sleep(3000);

			slidersPage.holdAndDragSlider(40,0);
			logger.info("Step 2: holdAndDragSlider", true);
			Thread.sleep(3000);

	        // Get updated value
	        String updatedValue = slidersPage.valueText.getText();
	        logger.info("Step 3: Updated slider value: " + updatedValue);

	        // Simple verification
	        int value = Integer.parseInt(updatedValue);
	        if (value >= 40 && value <= 60) {
	            logger.info("✅ Slider moved successfully and value is within expected range.");
	        } else {
	            logger.info("❌ Slider movement verification failed.");
	        }

		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
			throw e;
		} catch (AssertionError e) {
			logger.error("AssertionError: "+e.getMessage());
			throw e;
		}
		
		logger.debug("Application logging ends");
		logger.info("Finished *** TC004_Sliders ***");

	}

}
	

