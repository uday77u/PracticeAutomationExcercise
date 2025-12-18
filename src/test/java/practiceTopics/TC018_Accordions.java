package practiceTopics;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TC018_Accordions extends BaseTest {

	@Test
	public void testAccordions() {
		try {
			logger.debug("Started Logging");
			logger.info("starting *** TC018_Accordions***");
			
			HomePage homePage=new HomePage(driver);
			AccordionsPage accordionsPage=new AccordionsPage(driver);
			
			homePage.clickAccordionsLink();
			System.out.println("Step 1: clicked on AccordionsLink");
			
			accordionsPage.clickedClickToSeeMoreAccordion();
			System.out.println("Step 2: cliked on clickToSeeMore");
		
			assertEquals(accordionsPage.getClickToSeeMoreAccordionText(), "This is an accordion item.","mis match accordion content");
			System.out.println("accordion content: "+accordionsPage.getClickToSeeMoreAccordionText());
			
			}
			catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
			}

			logger.debug("Application logging ends");
			logger.info("Finished *** TC018_Accordions ***");
			
		
		
		
	}
}




/* example
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC018_Accordions {

    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://practice-automation.com/accordions/");

            // Locate all accordion headers
            // Assuming the accordion headers are <button> (or some clickable element) inside some container
            // Here, we check for elements with a class or tag; adjust selector as per real HTML
            List<WebElement> accordionHeaders = driver.findElements(By.cssSelector(".accordion-header, .accordion-item h3, button"));

            System.out.println("Found " + accordionHeaders.size() + " accordion headers");

            for (int i = 0; i < accordionHeaders.size(); i++) {
                WebElement header = accordionHeaders.get(i);

                System.out.println("Clicking accordion header #" + (i+1) + ": " + header.getText());
                
                // Click to expand
                header.click();

                // Wait until the associated content is visible
                // This assumes that when you expand, some sibling or parent container becomes visible / expanded
                // You must inspect the HTML of the page to find how content div is structured relative to header.
                // For example, if content is a next sibling with class ".accordion-content":
                By contentLocator = By.xpath(
                    "(//div[contains(@class, 'accordion-content')])[" + (i+1) + "]"
                );

                WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(contentLocator));
                System.out.println("Content for header #" + (i+1) + " is displayed: " + content.getText());

                // Optionally, you could assert something about the content text
                // For example:
                // assertTrue(content.getText().contains("expected substring"));

                // Click again to collapse (if needed)
                header.click();
                // Or wait for invisibility if the accordion collapses:
                wait.until(ExpectedConditions.invisibilityOf(content));
            }

        } finally {
            driver.quit();
        }
    }
}
*/