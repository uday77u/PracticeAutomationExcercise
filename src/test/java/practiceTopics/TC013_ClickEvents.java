package practiceTopics;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC013_ClickEvents extends BaseTest{
	
	@Test
	public void ClickEvents() {
		
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC013_ClickEvents ***");
			
			HomePage homePage=new HomePage(driver);
			ClickEventsPage clickEventsPage=new ClickEventsPage(driver);
			
			homePage.clickClickEventsLink();
			System.out.println("Step 1: clicked ClickEventsLink");
			
			clickEventsPage.clickCatBtn();
			System.out.println("Step 1: clicked on CatBtn ");
			
			assertEquals(clickEventsPage.getAnimalSoundTxt(), "Meow!");
			System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
			
			SoftAssert sa=new SoftAssert();
			clickEventsPage.clickDogBtn();
			System.out.println("Step 1: clickede on DogBtn");
			
			sa.assertEquals(clickEventsPage.getAnimalSoundTxt(), "Woof!");
			System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
			
			clickEventsPage.clickPigBtn();
			System.out.println("Step 1: clicked PigBtn");
			
			sa.assertEquals(clickEventsPage.getAnimalSoundTxt(), "Oink!");
			System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
			
			clickEventsPage.clickCowBtn();
			System.out.println("Step 1: clicked on CowBtn");
			
			sa.assertEquals(clickEventsPage.getAnimalSoundTxt(), "Moo!");
			System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
			
			sa.assertAll();
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished *** TC013_ClickEvents  ***");
			
		
		
		
		
	}
	
	
}
