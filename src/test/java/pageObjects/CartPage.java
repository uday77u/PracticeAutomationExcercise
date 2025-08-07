package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//-------------------------------------------Locators-----------------------------------------
	@FindBy(xpath = "//a[text()='Stylish Dress']")
	private WebElement StylishDress;
	@FindBy(xpath = "//a[text()='Men Tshirt']")
	private WebElement Tshirt;
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement btnProceedToCheckout;
	@FindBy(xpath = "//u[text()='Register / Login']")
	private WebElement btnRegisterOrLogin;
	
	@FindBy(xpath = "//a[@class='cart_quantity_delete']")
	private WebElement product1DeleteCrossMark;
	

	
//------------------------------------------Method--------------------------------------------
	public boolean StylishDressExist() {
		return StylishDress.isDisplayed();
	}
	public boolean TshirtExist() {
		return Tshirt.isDisplayed();
	}
	public void clickBtnProceedToCheckout() {
		btnProceedToCheckout.click();
	}
	public void clickBtnRegisterOrLogin() {
		btnRegisterOrLogin.click();
	}
	
	public void clickProduct1DeleteCrossMark() {
		product1DeleteCrossMark.click();
	}
	
	
}
