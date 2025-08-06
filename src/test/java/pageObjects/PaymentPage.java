package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//---------------Payment Locators----------------------------------------
		@FindBy(css = "[name='name_on_card']") private WebElement txtNameOnCard;
		@FindBy(css = "[name='card_number']") private WebElement txtCardNumber;
		@FindBy(css = "[name='cvc']") private WebElement txtCVC;
		@FindBy(css = "[name='expiry_month']") private WebElement txtExpiryMonth;
		@FindBy(css = "[name='expiry_year']") private WebElement txtExpiryYear;
		@FindBy(id = "submit") private WebElement btnPayAndConfirmOrder;
		
		@FindBy(xpath = "//div[@class='alert-success alert']") private WebElement msgSuccess;

		
		
		
		
		
		
		
//-----------------------------Methods-----------------------------		
		public void settxtNameOnCard(String comment) {
			txtNameOnCard.sendKeys(comment);
		}
		public void settxtCardNumber(String comment) {
			txtCardNumber.sendKeys(comment);
		}
		public void settxtCVC(String comment) {
			txtCVC.sendKeys(comment);
		}
		public void settxtExpiryMonth(String comment) {
			txtExpiryMonth.sendKeys(comment);
		}
		public void settxtExpiryYear(String comment) {
			txtExpiryYear.sendKeys(comment);
		}
		public void clickbtnPayAndConfirmOrder() {
			btnPayAndConfirmOrder.click();
		}	
		public boolean msgSuccessExist() {
			return msgSuccess.isDisplayed();
		}	
		public String getMsgSuccess() {
			return msgSuccess.getText();
		}
}
