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
		@FindBy(css = "[name='name_on_card']") public WebElement txtNameOnCard;
		@FindBy(css = "[name='card_number']") public WebElement txtCardNumber;
		@FindBy(css = "[name='cvc']") public WebElement txtCVC;
		@FindBy(css = "[name='expiry_month']") public WebElement txtExpiryMonth;
		@FindBy(css = "[name='expiry_year']") public WebElement txtExpiryYear;
		@FindBy(id = "submit") public WebElement btnPayAndConfirmOrder;
		
		@FindBy(id = "success_message") public WebElement msgSuccess;

		
		
		
		
		
		
		
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
