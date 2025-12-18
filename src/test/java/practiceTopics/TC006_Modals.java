package practiceTopics;

import org.testng.annotations.Test;

public class TC006_Modals extends BaseTest{
	
	@Test
	public void simpleModal() throws InterruptedException {
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC006_Modals ***");
			
			HomePage homePage=new HomePage(driver);
			ModalsPage modalsPage=new ModalsPage(driver);
			
			homePage.clickModalsLink();
			System.out.println("Step 1: click on the Modalslink");
			
			modalsPage.clickSimpleModalButton();
			System.out.println("Step 2: clicked on simple Modal button");
			//Thread.sleep(3000);
			
			System.out.println("title of Modal: "+modalsPage.getSimplePopupTitle());
			Thread.sleep(3000);
			
			System.out.println("Step 3: Massage: "+modalsPage.getSimplePopupContent());
			Thread.sleep(3000);
			
			modalsPage.clickSimplePopupClose();
			System.out.println("Step 4: Close the Popeup");
			
			modalsPage.clickformModalButton();
			System.out.println("Step 5: clicked on formModal Button");
			
			modalsPage.EnterFormName("raam");
			System.out.println("Step 6: Entered the name in form");
			
			modalsPage.EnterFormEmail("Raam@gmaila.com");
			System.out.println("Step 7: Entered the email in the form");
			
			modalsPage.EnterFormTextAreaMessage("my message");
			System.out.println("Step 8: Entered the messaage");
			
			modalsPage.clickformSubmitButton();
			System.out.println("Step 9: Click on the submit button");
			
			
			
			
			
			
			
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished *** TC006_Modals ***");
			
		
		
	}

}
