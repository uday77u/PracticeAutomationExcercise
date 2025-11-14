package practiceTopics;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC004_Sliders extends BaseTest{
	@Test
	public void Sliders() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		SlidersPage slidersPage=new SlidersPage(driver);
		Reporter.log("TC004_Sliders",true);
		
		homePage.clickSlidersLink();
		Reporter.log("SlidersPage is opened", true);
		Thread.sleep(3000);

		slidersPage.holdAndDragSlider(40,0);
		Reporter.log("holdAndDragSlider", true);
		Thread.sleep(3000);

        // Get updated value
        String updatedValue = slidersPage.valueText.getText();
        System.out.println("Updated slider value: " + updatedValue);

        // Simple verification
        int value = Integer.parseInt(updatedValue);
        if (value >= 40 && value <= 60) {
            System.out.println("✅ Slider moved successfully and value is within expected range.");
        } else {
            System.out.println("❌ Slider movement verification failed.");
        }


	}

}
	

