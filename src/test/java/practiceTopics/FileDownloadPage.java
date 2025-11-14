package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage {

	public FileDownloadPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	@FindBy(xpath = "//a[text()='Download']")
	private WebElement NormalDownloadBtn;
	
	@FindBy(xpath = "(//a[text()='Download'])[2]")
	private WebElement PasswordProtededDownloadBtn;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement PasswordForDownloadPdf;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement SubmitBtn;
	
	
	//Methods
	public void clickNormalDownloadBtn() {
		NormalDownloadBtn.click();
	}
	
	public void clickPasswordProtededDownloadBtn() {
		PasswordProtededDownloadBtn.click();
	}
	
	public void enterPasswordForDownloadPdf(String pwd) {
		PasswordForDownloadPdf.sendKeys(pwd);
	}
	
	public void clickSubmitBtn() {
		SubmitBtn.click();
	}
	
}
