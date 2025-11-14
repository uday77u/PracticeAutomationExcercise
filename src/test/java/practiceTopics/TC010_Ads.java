package practiceTopics;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC010_Ads extends BaseTest {
	
	@Test
	public void Ads() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		AdsPage adsPage=new AdsPage(driver);		
		homePage.clickAdsLink();
		System.out.println("clicked on AdsLink");
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.alertIsPresent());
		
		//driver.switchTo().alert().dismiss();
		adsPage.clickCloseBtn();
		System.out.println("Ads is closed");

	}

	
	
}
