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

@FindBy(xpath = "//a[text()='Write Your Review']") private WebElement msgWriteReview;
@FindBy(css = "input[placeholder='Your Name']") private WebElement txtReviewName;
@FindBy(css = "input[placeholder='Email Address']") private WebElement txtReviewEmailAddress;
@FindBy(css = "textarea[placeholder='Add Review Here!']") private WebElement txtAreaReviewHere;
@FindBy(css = "#button-review") private WebElement buttonReview;
	
	
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


public boolean isMsgWriteReviewDisplayed() {
	return msgWriteReview.isDisplayed();
}
public String getMsgWriteReview() {
	return msgWriteReview.getText();
}
public void enterReviewName(String name) {
	txtReviewName.sendKeys(name);
}

public void enterReviewEmailAddress(String email) {
	txtReviewEmailAddress.sendKeys(email);
}

public void enterReviewHere(String review) {
	txtAreaReviewHere.sendKeys(review);
}

public void clickButtonReview() {
	buttonReview.click();
}
}
