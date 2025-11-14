package practiceTopics;

import org.testng.annotations.Test;

public class TC014_Spinners extends BaseTest{

	@Test
	public void Spinners() {
		HomePage homePage=new HomePage(driver);
		
		
		homePage.clickSpinnersLink();
		System.out.println("clicked on SpinnersLink");
		
		
	}
}
