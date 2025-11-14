package practiceTopics;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC001_javaScriptDelays extends BaseTest{
	@Test
	public void waitForLiftOffText() {
	
		HomePage homePage = new HomePage(driver);
		JavascriptDelaysPage javascriptDelaysPage = new JavascriptDelaysPage(driver);
		Reporter.log("TC001_javaScriptDelays",true);

		
		homePage.clickJavaScriptDelaysLink(driver);
		
		javascriptDelaysPage.clickStartButton(driver);
		System.out.println("Clicked on the 'Start' button");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(javascriptDelaysPage.delayText, "Liftoff!"));
		
		assertTrue(javascriptDelaysPage.delayText.getText().contains("Liftoff"),"'Liftoff' is not present");
		System.out.println("Liftoff' is present");
	}

}
