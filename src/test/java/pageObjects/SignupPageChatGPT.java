package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPageChatGPT extends BasePage {

	 public SignupPageChatGPT(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	    //---------------------- Account Info Section ---------------------------

	    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	    private WebElement msgEnterAccInfo;

	    @FindBy(id = "id_gender1") private WebElement mr;
	    @FindBy(id = "id_gender2") private WebElement mrs;
	    @FindBy(id = "name") private WebElement name;
	    @FindBy(id = "password") private WebElement password;
	    @FindBy(id = "days") private WebElement day;
	    @FindBy(id = "months") private WebElement month;
	    @FindBy(id = "years") private WebElement year;

	    @FindBy(id = "newsletter") private WebElement signUpForOurNewsletter;
	    @FindBy(id = "optin") private WebElement receiveSpecialOffersFromOu;

	    //---------------------- Address Info Section ---------------------------

	    @FindBy(xpath = "//b[normalize-space()='Address Information']")
	    private WebElement addressInformation;

	    @FindBy(id = "first_name") private WebElement firstName;
	    @FindBy(id = "last_name") private WebElement lastName;
	    @FindBy(id = "company") private WebElement company;
	    @FindBy(id = "address1") private WebElement address;
	    @FindBy(id = "address2") private WebElement address2;
	    @FindBy(id = "country") private WebElement country;
	    @FindBy(id = "state") private WebElement state;
	    @FindBy(id = "city") private WebElement city;
	    @FindBy(id = "zipcode") private WebElement zipcode;
	    @FindBy(id = "mobile_number") private WebElement mobileNumber;

	    @FindBy(xpath = "//button[normalize-space()='Create Account']")
	    private WebElement createAccount;

	    //---------------------- Post Account Creation --------------------------

	    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
	    private WebElement accountCreated;

	    @FindBy(xpath = "//a[normalize-space()='Continue']")
	    private WebElement continueAfterAccountCreation;

	    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	    private WebElement loggedInAs;

	    //---------------------- Account Deletion -------------------------------

	    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
	    private WebElement deleteAccount;

	    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	    private WebElement accountDeleted;

	    @FindBy(xpath = "(//a[normalize-space()='Continue'])[last()]")
	    private WebElement continueAfterDeletion;

	    //---------------------- Methods ----------------------------------------

	    public boolean msgEnterAccountInfo() {
	        return msgEnterAccInfo.isDisplayed();
	    }

	    public void clickMr() {
	        mr.click();
	    }

	    public void clickMrs() {
	        mrs.click();
	    }

	    public void setPassword(String psw) {
	        password.sendKeys(psw);
	    }

	    public void setDay(String Day) {
	        new Select(day).selectByValue(Day);
	    }

	    public void setMonth(String Month1) {
	        new Select(month).selectByVisibleText(Month1);
	    }

	    public void setYear(String Year) {
	        new Select(year).selectByValue(Year);
	    }

	    public void clickSignUpForOurNewsletter() {
	        signUpForOurNewsletter.click();
	    }

	    public void clickReceiveSpecialOffersFromOu() {
	        receiveSpecialOffersFromOu.click();
	    }

	    public boolean msgAddressInformation() {
	        return addressInformation.isDisplayed();
	    }

	    public void setFirstName(String user) {
	        firstName.sendKeys(user);
	    }

	    public void setLastName(String user) {
	        lastName.sendKeys(user);
	    }

	    public void setCompany(String user) {
	        company.sendKeys(user);
	    }

	    public void setAddress(String user) {
	        address.sendKeys(user);
	    }

	    public void setAddress2(String user) {
	        address2.sendKeys(user);
	    }

	    public void setCountry(String countryName) {
	        new Select(country).selectByVisibleText(countryName);
	    }

	    public void setState(String user) {
	        state.sendKeys(user);
	    }

	    public void setCity(String user) {
	        city.sendKeys(user);
	    }

	    public void setZipcode(String user) {
	        zipcode.sendKeys(user);
	    }

	    public void setMobileNumber(String user) {
	        mobileNumber.sendKeys(user);
	    }

	    public void clickCreateAccount() {
	        createAccount.click();
	    }

	    public boolean msgAccountCreated() {
	        return accountCreated.isDisplayed();
	    }

	    public void clickContinueAfterCreation() {
	        continueAfterAccountCreation.click();
	    }

	    public boolean msgLoggedInAs(String username) {
	        return loggedInAs.getText().contains(username);
	    }

	    public void clickDeleteAccount() {
	        deleteAccount.click();
	    }

	    public boolean msgAccountDeleted() {
	        return accountDeleted.isDisplayed();
	    }

	    public void clickContinueAfterDeletion() {
	        continueAfterDeletion.click();
	    }

	    //---------------------- Locators for WaitHelper ------------------------

	    public By locatorEnterAccountInfo() {
	        return By.xpath("//b[normalize-space()='Enter Account Information']");
	    }

	    public By locatorAccountCreated() {
	        return By.xpath("//b[normalize-space()='Account Created!']");
	    }

	    public By locatorLoggedInAs() {
	        return By.xpath("//a[contains(text(),'Logged in as')]");
	    }

	    public By locatorAccountDeleted() {
	        return By.xpath("//b[normalize-space()='Account Deleted!']");
	    }

}
