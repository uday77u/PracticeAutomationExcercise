package practiceTopics;

import org.testng.annotations.Test;

public class TC012_FileDownload extends BaseTest{
	
	@Test
	public void FileDownload() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		FileDownloadPage fileDownloadPage=new FileDownloadPage(driver);
		
		homePage.clickFileDownloadLink();
		System.out.println("clicked FileDownloadLink");
		
		fileDownloadPage.clickNormalDownloadBtn();
		System.out.println("clicked on NormalDownloadBtn");
		
		fileDownloadPage.clickPasswordProtededDownloadBtn();
		System.out.println("clicked PasswordProtededDownloadBtn");
		Thread.sleep(5000);
		
		fileDownloadPage.enterPasswordForDownloadPdf("asdfg");
		System.out.println("entered PasswordForDownloadPdf");
		
		fileDownloadPage.clickSubmitBtn();
		System.out.println("clicked SubmitBtn");
		Thread.sleep(5000);

		
	}
}
