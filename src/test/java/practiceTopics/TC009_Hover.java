package practiceTopics;

import org.testng.annotations.Test;

public class TC009_Hover extends BaseTest{

	@Test
	public void Hover() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		HoverPage hoverPage=new HoverPage(driver);
		
		homePage.clickHoverLink();
		System.out.println("click on HoverLink");
		Thread.sleep(5000);
		
		System.out.println("Before mouse hover:"+hoverPage.getMouseOverTabTxt());
		hoverPage.HoverMouseOverTab();
		System.out.println("mouse HoverMouseOverTab");
		
		System.out.println("After mouse hover:"+hoverPage.getMouseOverTabTxt());
	}
	
}
