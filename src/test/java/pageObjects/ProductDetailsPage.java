package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//----------------------------------Locator---------------------------------------
	
	
	@FindBy(id = "quantity")
	WebElement txtQuantity;
	
	@FindBy(xpath =  "//button[@type='button']")
	WebElement btnAddToCart;
	

@FindBy(xpath="//u[normalize-space()='View Cart']")  private WebElement lnkViewCart;
@FindBy(css =".cart_quantity")  private WebElement qtyInCart;
	
	
	
	//-----------------------Methods--------------------------------------------------
	public void setQuantity(String qty) {
		txtQuantity.clear();
		txtQuantity.sendKeys(qty);
	}
	
	public void clickBtnAddToCart() {
		btnAddToCart.click();
	}
	
	public void clickLnkViewCart() {
		lnkViewCart.click();
	}
	
	public String getQtyInCart() {
		return qtyInCart.getText();
	}

}
