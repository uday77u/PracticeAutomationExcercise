package practiceTopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class expBrokenImage {
	
	    public static void main(String[] args) throws IOException {
	        WebDriver driver = new ChromeDriver();
	        try {
	            driver.get("https://practice-automation.com/broken-images/");

	            // Wait a little if needed, or ensure page is loaded
	            // e.g. Thread.sleep(2000) — but better to use WebDriverWait

	            List<WebElement> images = driver.findElements(By.tagName("img"));
	            System.out.println("Total images found: " + images.size());

	            for (WebElement img : images) {
	                String imgUrl = img.getAttribute("src");
	                System.out.println("Checking image URL: " + imgUrl);

	                if (imgUrl == null || imgUrl.trim().isEmpty()) {
	                    System.out.println(" → MISSING src (BROKEN)");
	                    continue;
	                }

	                try {
	                    HttpURLConnection connection = (HttpURLConnection) (new URL(imgUrl).openConnection());
	                    connection.setRequestMethod("GET");
	                    connection.connect();

	                    int code = connection.getResponseCode();
	                    if (code >= 400) {
	                        System.out.println(" → BROKEN (HTTP status: " + code + ")");
	                    } else {
	                        System.out.println(" → OK (HTTP status: " + code + ")");
	                    }
	                } catch (Exception e) {
	                    System.out.println(" → ERROR: " + e.getMessage());
	                }
	            }
	        } finally {
	            driver.quit();
	        }
	    }
	


}

