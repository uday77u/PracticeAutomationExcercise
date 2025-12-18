package practiceTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksChecker {
    public static void main(String[] args) {
        // Setup WebDriver (set path to your chromedriver if needed)
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://practice-automation.com/broken-links/");

            // Get all link elements
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Total links found: " + links.size());

            for (WebElement link : links) {
                String url = link.getAttribute("href");
                System.out.println("Checking URL: " + url);

                if (url == null || url.isEmpty()) {
                    System.out.println(" → HREF is empty or null; skipping");
                    continue;
                }

                try {
                    HttpURLConnection httpConn = (HttpURLConnection) (new URL(url).openConnection());
                    httpConn.setRequestMethod("GET");
                    httpConn.setConnectTimeout(5000);
                    httpConn.connect();
                    int responseCode = httpConn.getResponseCode();

                    // You can decide your threshold; here ≥400 = broken
                    if (responseCode >= 400) {
                        System.out.println(" → BROKEN link: " + url + " (Status: " + responseCode + ")");
                    } else {
                        System.out.println(" → Valid link: " + url + " (Status: " + responseCode + ")");
                    }
                } catch (Exception e) {
                    System.out.println(" → ERROR while checking link: " + url + " → " + e.getMessage());
                }
            }
        } finally {
            driver.quit();
        }
    }
}
