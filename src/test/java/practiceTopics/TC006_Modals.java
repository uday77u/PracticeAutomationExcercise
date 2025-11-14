package practiceTopics;

import org.testng.annotations.Test;

public class TC006_Modals extends BaseTest{
	
	@Test
	public void simpleModal() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		ModalsPage modalsPage=new ModalsPage(driver);
		
		homePage.clickModalsLink();
		System.out.println("click on the Modalslink");
		
		modalsPage.clickSimpleModalButton();
		System.out.println("clicked on simple Modal button");
		//Thread.sleep(3000);
		
		System.out.println("title of Modal: "+modalsPage.getSimplePopupTitle());
		Thread.sleep(3000);
		
		System.out.println("Massage: "+modalsPage.getSimplePopupContent());
		Thread.sleep(3000);
		
		modalsPage.clickSimplePopupClose();
		System.out.println("Close the Popeup");
		
		modalsPage.clickformModalButton();
		System.out.println("clicked on formModal Button");
		
		modalsPage.EnterFormName("raam");
		System.out.println("Entered the name in form");
		
		modalsPage.EnterFormEmail("Raam@gmaila.com");
		System.out.println("Entered the email in the form");
		
		modalsPage.EnterFormTextAreaMessage("my message");
		System.out.println("Entered the messaage");
		
		modalsPage.clickformSubmitButton();
		System.out.println("Click on the submit button");
		
	}

}
