package practiceTopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpinnerTest {

    public static void main(String[] args) {
        // Set up ChromeDriver (ensure correct path for your chromedriver)
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the target page
            driver.get("https://practice-automation.com/spinners/");

            // Locate the spinner element (modify selector if needed)
            By spinnerLocator = By.cssSelector(".spinner");  // adjust if the class or selector is different

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait until spinner appears (optional)
            wait.until(ExpectedConditions.visibilityOfElementLocated(spinnerLocator));

            // Then wait until spinner disappears / has class spinner-hidden
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    WebElement spinner = d.findElement(spinnerLocator);
                    String cssClass = spinner.getAttribute("class");
                    // return true when spinner has class spinner-hidden
                    return cssClass != null && cssClass.contains("spinner-hidden");
                }
            });

            System.out.println("Spinner is now hidden, test can proceed.");

            // Continue with further assertions / actions
            // e.g., verify that the main content is visible
            WebElement content = driver.findElement(By.cssSelector("body")); // change selector as desired
            if (content.isDisplayed()) {
                System.out.println("Main content visible.");
            } else {
                System.out.println("Main content not visible as expected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up
            driver.quit();
        }
    }
}
