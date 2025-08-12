package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KookieKidsPage extends BasePage {

	public KookieKidsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//-----------------------------------locators-----------------------------
	@FindBy(xpath = "//h2[text()='Brand - Kookie Kids Products']") private WebElement messageBrandKookieKidsProducts;
	
	
	
	//-----------------------------------Methods------------------------------
	public boolean isMessageBrandKookieKidsProducts() {
		return messageBrandKookieKidsProducts.isDisplayed();
		
		
		
		
		
		
		
		
		
		
		
		/* improved for brand class
		
	    private By brandHeading = By.cssSelector("h2.title.text-center");
	    private By productItems = By.cssSelector(".features_items .product-image-wrapper");

	    public boolean isBrandHeadingDisplayed(String brandName) {
	        WebElement heading = driver.findElement(brandHeading);
	        return heading.isDisplayed() && heading.getText().trim().equalsIgnoreCase("Brand - " + brandName + " Products");
	    }

	    public List<WebElement> getAllProductElements() {
	        return driver.findElements(productItems);
	    }*/
	}
}
