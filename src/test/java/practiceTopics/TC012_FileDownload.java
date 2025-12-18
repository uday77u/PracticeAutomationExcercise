package practiceTopics;

import org.testng.annotations.Test;

public class TC012_FileDownload extends BaseTest{
	
	@Test
	public void FileDownload() throws InterruptedException {
		try {
			logger.debug("Started Logging");
			logger.info("starting ***TC012_FileDownload ***");
			
			HomePage homePage=new HomePage(driver);
			FileDownloadPage fileDownloadPage=new FileDownloadPage(driver);
			
			homePage.clickFileDownloadLink();
			System.out.println("Step 1: clicked FileDownloadLink");
			
			fileDownloadPage.clickNormalDownloadBtn();
			System.out.println("Step 2: clicked on NormalDownloadBtn");
			
			fileDownloadPage.clickPasswordProtededDownloadBtn();
			System.out.println("Step 3: clicked PasswordProtededDownloadBtn");
			Thread.sleep(5000);
			
			fileDownloadPage.enterPasswordForDownloadPdf("asdfg");
			System.out.println("Step 4: entered PasswordForDownloadPdf");
			
			fileDownloadPage.clickSubmitBtn();
			System.out.println("Step 5: clicked SubmitBtn");
			Thread.sleep(5000);
			
			
			
			
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished *** TC012_FileDownload ***");
			
		

		
	}
}
