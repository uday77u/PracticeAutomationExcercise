package practiceTopics;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC013_ClickEvents extends BaseTest{
	
	@Test
	public void ClickEvents() {
		HomePage homePage=new HomePage(driver);
		ClickEventsPage clickEventsPage=new ClickEventsPage(driver);
		
		homePage.clickClickEventsLink();
		System.out.println("clicked ClickEventsLink");
		
		clickEventsPage.clickCatBtn();
		System.out.println("clicked on CatBtn ");
		
		assertEquals(clickEventsPage.getAnimalSoundTxt(), "Meow!");
		System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
		
		SoftAssert sa=new SoftAssert();
		clickEventsPage.clickDogBtn();
		System.out.println("clickede on DogBtn");
		
		sa.assertEquals(clickEventsPage.getAnimalSoundTxt(), "Woof!");
		System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
		
		clickEventsPage.clickPigBtn();
		System.out.println("clicked PigBtn");
		
		sa.assertEquals(clickEventsPage.getAnimalSoundTxt(), "Oink!");
		System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
		
		clickEventsPage.clickCowBtn();
		System.out.println("clicked on CowBtn");
		
		sa.assertEquals(clickEventsPage.getAnimalSoundTxt(), "Moo!");
		System.out.println("AnimalSoundTxt: "+clickEventsPage.getAnimalSoundTxt());
		
		sa.assertAll();
		
		
		
	}
	
	
}
