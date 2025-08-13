package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends BasePage {

public HomePage(WebDriver driver) {
		super(driver);
	}


//-------------------------Locators--------------------------------------------------------------------

@FindBy(xpath=("//a[normalize-space()='Signup / Login']"))
private WebElement LnkSignup;

@FindBy(xpath="//input[@placeholder='Name']")
private WebElement Name;

@FindBy(xpath="//input[@data-qa='signup-email']") 
private WebElement emailAddress;

@FindBy(xpath="//button[normalize-space()='Signup']") 
private WebElement BtnSignup;

@FindBy(xpath="//h2[text()='New User Signup!']")
private WebElement msgSignup;

@FindBy(xpath="//h2[text()='Login to your account']")
private WebElement msgLoginToAccount;



@FindBy(xpath="//input[@data-qa='login-email']") 
private WebElement emailAddressLogin;

@FindBy(xpath="//input[@placeholder='Password']") 
private WebElement password;

@FindBy(xpath="//button[normalize-space()='Login']") 
private WebElement login;


@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
private WebElement errorMsgIncorrectEmailPassword;

@FindBy(xpath = "//p[text()='Email Address already exist!']")
private WebElement errorMsgEmailAlready;

@FindBy(xpath="//a[contains(text(),'Contact')]") 
private WebElement contactUs;


@FindBy(xpath="//a[normalize-space()='Test Cases']") @CacheLookup private WebElement testCases;
@FindBy(xpath="//a[@href='/products']") @CacheLookup private WebElement Products;

@FindBy(id = "footer") private WebElement HomePageFooter;
@FindBy(xpath="//h2[text()='Subscription']") private WebElement Subscription;
@FindBy(id = "susbscribe_email") private WebElement susbscribeEmail;
@FindBy(id = "subscribe") private WebElement btnSubscribeArrow;

@FindBy(xpath  = "//a[contains(text(),'Cart')]") public WebElement btnCart;
@FindBy(xpath  = "//a[@href='/product_details/4']") private WebElement btnViewProduct4;


@FindBy(xpath="//div[3]//div[1]//div[1]//div[2]//div[1]//a[1]") private WebElement addToCartTshirt;
@FindBy(xpath="//div[5]//div[1]//div[1]//div[2]//div[1]//a[1]") private WebElement addToCartDress;
@FindBy(xpath  = "//button[text()='Continue Shopping']")
private WebElement btnContinueShopping;

@FindBy(xpath = ("//div[@class='alert-success alert']")) private WebElement msgAlertSentMail;

@FindBy(xpath = "(//div[@class='productinfo text-center'])[1]") private WebElement product1;
@FindBy(xpath = "(//a[@data-product-id='1' and text()='Add to cart'])[1]") private WebElement btnAddToCartProduct1;
@FindBy(xpath = "(//div[@class='productinfo text-center'])[2]") private WebElement product2;
@FindBy(xpath = "(//a[@data-product-id='2' and text()='Add to cart'])[1]") private WebElement btnAddToCartProduct2;
@FindBy(xpath = "//u[text()='View Cart']") private WebElement LnkViewCart;

@FindBy(xpath = "//h2[text()='Category']") private WebElement Categories;

@FindBy(xpath = "//a[@href='#Women']") private WebElement womenCategories;
@FindBy(xpath = "//a[text()='Dress ']") private WebElement DressSubWomenCategories;
@FindBy(xpath = "//span[contains(text(),'Dress')]") private WebElement messageDressOnPage;

@FindBy(xpath = "//a[@href='#Men']") private WebElement menCategories;
@FindBy(xpath = "//a[text()='Jeans ']") private WebElement JeansSubWomenCategories;
@FindBy(xpath = "//span[text()='Jeans']") private WebElement messageJeansOnPage;
@FindBy(xpath = "//p[contains(text(),'Copyright')]") private WebElement footerCopyright;
@FindBy(xpath = "//h2[text()='recommended items']") private WebElement msgRecommendedItems;
@FindBy(css = "#recommended-item-carousel") private List<WebElement> RecommendedItemsList;
@FindBy(css = "#recommended-item-carousel") private WebElement RecommendedItems;
@FindBy(xpath = "//a[text()='Add to cart' and @data-product-id='4']") private WebElement AddToCartRecommendedProduct4;
@FindBy(css = "#scrollUp") private WebElement scrollUpArrow;

@FindBy(xpath = "//h2[contains(text(),'Full-Fledged')]") private WebElement msgFullFledged;



public WebElement LocatorProduct1() {
	return product1;
}

public WebElement LocatorProduct2() {
	return product2;
}

public void mouseHoverToProduct1() {
	 Actions act =new Actions(driver);
     act.moveToElement(LocatorProduct1()).perform();
}

public void mouseHoverToProduct2() {
	 Actions act =new Actions(driver);
     act.moveToElement(LocatorProduct2()).perform();
}

public WebElement LocatoraddToCartTshirt() {
	return addToCartTshirt;
}

public WebElement LocatorbtnContinueShopping() {
	return btnContinueShopping;
}

public WebElement LocatoraddToCartDress() {
	return addToCartDress;
}

public WebElement LocatorCategories() {
	return Categories;
}

public WebElement LocatorMsgRecommendedItems() {
	return msgRecommendedItems;
}


//---------------------------------------------Methods for Locators------------------------------------
public void clickSignup() {
	LnkSignup.click();
}
public void setUserName(String user) {
	Name.sendKeys(user);
}
public void setEmail(String email) {
	emailAddress.sendKeys(email);
}
public void clickBtnSignup() {
	//BtnSignup.click();
	BtnSignup.submit();
}

public Boolean msgSignupVisible() {
	return msgSignup.isDisplayed();
}

public Boolean msgLoginToAccountVisible() {
	return msgLoginToAccount.isDisplayed();
}

public void setEmailAddressLogin(String user) {
	emailAddressLogin.sendKeys(user);
}

public void setPassword(String user) {
	password.sendKeys(user);
}
public void clickLogin() {
	login.click();
}

public boolean errorMsgExist(){
	return errorMsgIncorrectEmailPassword.isDisplayed();
}
public boolean errorMsgEmailAlreadyExist(){
	return errorMsgEmailAlready.isDisplayed();
}

public void clickContactUs() {
	contactUs.click();
}

public void clickTestCases() {
	testCases.click();
}

public void clickProducts() {
	Products.click();
}

public WebElement LocatorHomePageFooter() {
	return HomePageFooter;
}
public boolean msgSubscription() {
	return Subscription.isDisplayed();
}

public void setSusbscribeEmailname(String email) {
	susbscribeEmail.sendKeys(email);
}
public void clickbtnSubscribeArrow() {
	btnSubscribeArrow.click();
}

public void clickbtnCart() {
	//btnCart.click();
	
	//sol2
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinueShopping).click().perform();
	
	btnCart.sendKeys(Keys.ENTER);
	
	
}
public void clickBtnViewProduct4() {
	btnViewProduct4.click();
}
public void clickAddToCartTshirt() {
	addToCartTshirt.click();
}
public void clickAddToCartDress() {
	addToCartDress.click();
}
public String getAddToCartTshirt() {
	return addToCartTshirt.getText();
}
public String getAddToCartDress() {
	return addToCartDress.getText();
}
public void clickBtnContinueShopping() {
	//sol1
	//btnContinueShopping.click();
	
	//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinueShopping).click().perform();
					
		//sol4
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnContinueShopping);
		
		//Sol 5
		//btnContinueShopping.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinueShopping)).click();
}

public boolean getmsgAlertSentMailExist() {
	return msgAlertSentMail.isDisplayed();
}
public String getMsgAlertSentMail() {
	return msgAlertSentMail.getText();
}

public void clickbtnAddToCartProduct1() {
	// btnAddToCartProduct1.click();
	 
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", btnAddToCartProduct1);
}

public void clickbtnAddToCartProduct2() {
	 //btnAddToCartProduct2.click();
	
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", btnAddToCartProduct2);
}

public void clickLnkViewCart() {
	//LnkViewCart.click();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", LnkViewCart);
}

public void clickBtnWomenCategories() {
	womenCategories.click();
}
public void clickBtnDressSubWomenCategories() {
	DressSubWomenCategories.click();
}

public boolean isMessageDressOnPage() {
	return messageDressOnPage.isDisplayed();
}

public void clickBtnMenCategories() {
	menCategories.click();
}
public void clickBtnJeansSubMenCategories() {
	JeansSubWomenCategories.click();
}

public boolean isMessageJeansOnPage() {
	return messageJeansOnPage.isDisplayed();
}
public WebElement LocatorMessageDressOnPage() {
	return messageDressOnPage;
}

public WebElement LocatorMessageJeansOnPage() {
	return messageJeansOnPage;
}

public boolean areFooterWebElementsDisplayed() {
	return footerCopyright.isDisplayed()
			&& Subscription.isDisplayed()
			&& btnSubscribeArrow.isDisplayed();
}

public void isMsgRecommendedItems() {
	msgRecommendedItems.isDisplayed();
}

//future implement for all recommended items visibility
public boolean areRecommendedItemsEmpty() {
	return RecommendedItemsList.isEmpty();
}

public boolean isRecommendedItems() {
	return RecommendedItems.isDisplayed();
}
public void clickAddToCartRecommendedProduct4() {
	//AddToCartRecommendedProduct4.click();
	//sol4
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", btnContinueShopping);
}
public void clickScrollUpArrow() {
	//scrollUpArrow.click();
	Actions ac=new Actions(driver);
	ac.click(scrollUpArrow).perform();;
}

public boolean isMsgFullFledgedDisplayed() {
	return msgFullFledged.isDisplayed();
}
public String getMsgFullFledged() {
	return msgFullFledged.getText();
}

public WebElement LocatorMsgFullFledged() {
	return msgFullFledged;
}






}
