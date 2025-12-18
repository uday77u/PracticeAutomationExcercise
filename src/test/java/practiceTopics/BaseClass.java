package practiceTopics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;
import java.time.temporal.ChronoUnit;

public class BaseClass {
    // read configuration values
    ReadConfig readConfig = new ReadConfig();
    public String BASE_URL = readConfig.getBaseURL();
    public String USER_NAME = readConfig.getUsername();
    public String USER_EMAIL = readConfig.getUserEmail();
    public String PASSWORD = readConfig.getPassword();
    public String USER_EMAIL_Temp = "tempAbc@gmail.com";
    public static WebDriver driver;
    public Logger logger;
    // default explicit wait timeout (seconds)
    protected final int TIMEOUT = 15;

    @BeforeMethod
    @Parameters({ "Browser" })
    public void setup(@Optional("chrome") String Br) {
        logger = LogManager.getLogger(this.getClass());
        logger.info("Starting setup for browser: " + Br);

        // Option C: headless only when -Dheadless=true is passed
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        logger.info("Headless mode: " + isHeadless);

        if (Br.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
                options.addArguments("--headless=new");
                // recommended for headless to avoid some issues
                options.addArguments("--window-size=1920,1080");
            }
            // add common useful args
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            logger.info("Chrome browser is launched.");
        } else if (Br.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("--headless");
            }
            driver = new FirefoxDriver(options);
            logger.info("Firefox browser is launched.");
        } else if (Br.equalsIgnoreCase("edge")) {
            // Edge headless support may vary; we rely on default behavior
            driver = new EdgeDriver();
            logger.info("Edge browser is launched.");
        } else {
            logger.error("Enter a proper browser name. Launch aborted.");
            throw new IllegalArgumentException("Unsupported browser: " + Br);
        }

        // Maximize in headed mode; in headless we've already set window-size
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            // ignore if headless / remote doesn't support maximize
        }

        // Light implicit wait (we rely primarily on explicit waits)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to base URL
        logger.info("Navigating to baseURL: " + BASE_URL);
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser is closed.");
        }
    }

    public String getScreenshot(String tname) throws IOException {
        if (driver == null)
            throw new IllegalStateException("driver is null");

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator
                + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        FileUtils.copyFile(source, targetFile);
        return targetFilePath;
    }

    // utility: explicit wait for clickable
    public void waitForWebElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(TIMEOUT, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // utility: wait for visibility
    public void waitForVisibilityOfWebelement(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(TIMEOUT, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(webelement));
    }

    // utility: scroll into view (fixed)
    public void scrollToViewWebElement(WebElement webelement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webelement);
    }

    // utility: safe click (waits + fallback to JS click)
    public void safeClick(WebElement element) {
        try {
            waitForWebElementToBeClickable(element);
            element.click();
        } catch (Exception e) {
            try {
                // fallback to JS if normal click fails
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
            } catch (Exception ex) {
                logger.error("safeClick failed for element: " + element, ex);
                throw ex;
            }
        }
    }

    // utility: safe type (waits + clear)
    public void safeType(WebElement element, String text) {
        waitForVisibilityOfWebelement(element);
        element.clear();
        element.sendKeys(text);
    }

    // utility: check current url contains segment
    public boolean isCurrentUrlWithSegment(String segment) {
        return driver.getCurrentUrl().contains(segment);
    }

    // utility: check current title contains segment
    public boolean isCurrentTitleWithSegment(String segment) {
        return driver.getTitle().contains(segment);
    }
}
