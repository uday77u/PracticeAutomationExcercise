package practiceTopics;

import org.testng.annotations.Test;

public class TC011_gestures extends BaseTest {
	@Test
	public void gestures() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		GesturesPage GesturesPage=new GesturesPage(driver);
		
		homepage.clickGesturesLink();
		System.out.println("Click on the GuestureLink");
		
		GesturesPage.DragMoveMeHeader();
		System.out.println("Draged the header");
		
		Thread.sleep(5000);
		
		GesturesPage.DragAndDropFromLeftToRightBox();
		System.out.println("Draged AndDrop From LeftToRightBox");
		Thread.sleep(5000);

		
		GesturesPage.DragAndDropFromRightToLeftBox();
		System.out.println("Draged and Drop FromRightToLeftBox");
		Thread.sleep(5000);

	}
	
}
