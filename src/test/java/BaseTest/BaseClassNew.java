package BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassNew implements frameWorkConstants {

    public static WebDriver driver;
    public Logger logger;

    @BeforeClass
    public void setup() {

        logger = LogManager.getLogger(this.getClass()); // log4j
/*
        // CHROME
        if (BROWSER.equalsIgnoreCase("chrome")) {

            if (HEADLESS_EXECUTION) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                logger.info("Chrome launched in HEADLESS mode");
            } 
            else {
                driver = new ChromeDriver();
                logger.info("Chrome launched in NORMAL mode");
            }
        }

        // FIREFOX
        else if (BROWSER.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Firefox launched");
        }

        // EDGE
        else if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            logger.info("Edge launched");
        }

        else {
            logger.error("Invalid Browser Name in config.properties");
            throw new RuntimeException("Invalid Browser");
        }
*/
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));

        logger.info("Browser maximized");
        driver.get(BASE_URL);
        logger.info("Navigated to: " + BASE_URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully\n");
        }
    }

    // Screenshot utility
    public String getScreenshot(String tname) throws IOException {

        if (driver == null)
            System.out.println("driver is null");

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        FileUtils.copyFile(source, targetFile);
        return targetFilePath;
    }

    // Verify current URL
    public boolean isCurrentUrlWithSegment(String segment) {
        return driver.getCurrentUrl().contains(segment);
    }

    // Verify title
    public boolean isCurrentTitleWithSegment(String segment) {
        return driver.getTitle().contains(segment);
    }

    // Explicit wait for element to be clickable
    public void waitForWebElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // Scroll element into view
    public void scrollToViewWebElement(WebElement webelement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webelement);
    }

    // Wait for visibility
    public void waitForVisibilityOfWebelement(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(webelement));
    }
}
