package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceTopics.BaseClass;

public class HomePageAE extends BaseClass {

    public HomePageAE(WebDriver driver) {
        // BaseClass.driver is static; ensure the instance points to same driver
        BaseClass.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //-------------------------Locators (improved & more stable) -------------------------------

    @FindBy(linkText = "Signup / Login")
    private WebElement lnkSignupOrLogin;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement inputEmailAddress;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    private WebElement btnSignup;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement msgSignup;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement msgLoginToAccount;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement inputEmailAddressLogin;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement errorMsgIncorrectEmailPassword;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement errorMsgEmailAlready;

    @FindBy(partialLinkText = "Contact")
    private WebElement contactUs;

    @FindBy(linkText = "Test Cases")
    private WebElement testCases;

    @FindBy(css = "a[href='/products']")
    private WebElement productsLink;

    @FindBy(id = "footer")
    private WebElement homePageFooter;

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscription;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmail;

    @FindBy(id = "subscribe")
    private WebElement btnSubscribe;

    @FindBy(css = "a[href='/view_cart']") // more stable cart link (if present)
    private WebElement btnCart;

    @FindBy(css = "a[href='/product_details/4']")
    private WebElement btnViewProduct4;

    // product Add to cart buttons using data-product-id where possible
    @FindBy(css = "a[data-product-id='1']")
    private WebElement btnAddToCartProduct1;

    @FindBy(css = "a[data-product-id='2']")
    private WebElement btnAddToCartProduct2;

    @FindBy(xpath = "//u[text()='View Cart']")
    private WebElement lnkViewCart;

    @FindBy(xpath = "//h2[text()='Category']")
    private WebElement categories;

    @FindBy(xpath = "//a[@href='#Women']")
    private WebElement womenCategories;

    @FindBy(xpath = "//a[text()='Dress ']")
    private WebElement dressSubWomenCategories;

    @FindBy(xpath = "//span[contains(text(),'Dress')]")
    private WebElement messageDressOnPage;

    @FindBy(xpath = "//a[@href='#Men']")
    private WebElement menCategories;

    @FindBy(xpath = "//a[text()='Jeans ']")
    private WebElement jeansSubMenCategories;

    @FindBy(xpath = "//span[text()='Jeans']")
    private WebElement messageJeansOnPage;

    @FindBy(xpath = "//p[contains(text(),'Copyright')]")
    private WebElement footerCopyright;

    @FindBy(xpath = "//h2[text()='recommended items']")
    private WebElement msgRecommendedItems;

    // recommended item carousel container
    @FindBy(css = "#recommended-item-carousel")
    private WebElement recommendedItemsContainer;

    // recommended product add to cart (targeting product id=4)
    @FindBy(xpath = "//a[text()='Add to cart' and @data-product-id='4']")
    private WebElement addToCartRecommendedProduct4;

    @FindBy(css = "#scrollUp")
    private WebElement scrollUpArrow;

    @FindBy(xpath = "//h2[contains(text(),'Full-Fledged')]")
    private WebElement msgFullFledged;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement msgAlertSentMail;

    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]")
    private WebElement product1;

    @FindBy(xpath = "(//div[@class='productinfo text-center'])[2]")
    private WebElement product2;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement btnContinueShopping;

    // ---------------------------- Element accessors & helpers ----------------------------

    public WebElement LocatorProduct1() {
        return product1;
    }

    public WebElement LocatorProduct2() {
        return product2;
    }

    public void mouseHoverToProduct1() {
        Actions act = new Actions(driver);
        act.moveToElement(LocatorProduct1()).perform();
    }

    public void mouseHoverToProduct2() {
        Actions act = new Actions(driver);
        act.moveToElement(LocatorProduct2()).perform();
    }

    // ---------------------------- Page actions (use BaseClass safe wrappers) --------------

    public void clickSignupOrLoginLink() {
        safeClick(lnkSignupOrLogin);
    }

    public void setUserName(String user) {
        safeType(inputName, user);
    }

    public void setEmail(String email) {
        safeType(inputEmailAddress, email);
    }

    public void clickBtnSignup() {
        // prefer submit only when element is a form submit; click is safer
        safeClick(btnSignup);
    }

    public Boolean msgSignupVisible() {
        try {
            waitForVisibilityOfWebelement(msgSignup);
            return msgSignup.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean msgLoginToAccountVisible() {
        try {
            waitForVisibilityOfWebelement(msgLoginToAccount);
            return msgLoginToAccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void setEmailAddressLogin(String user) {
        safeType(inputEmailAddressLogin, user);
    }

    public void setPassword(String pwd) {
        safeType(inputPassword, pwd);
    }

    public void clickLogin() {
        safeClick(btnLogin);
    }

    public boolean errorMsgExist() {
        try {
            waitForVisibilityOfWebelement(errorMsgIncorrectEmailPassword);
            return errorMsgIncorrectEmailPassword.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean errorMsgEmailAlreadyExist() {
        try {
            waitForVisibilityOfWebelement(errorMsgEmailAlready);
            return errorMsgEmailAlready.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContactUs() {
        safeClick(contactUs);
    }

    public void clickTestCases() {
        safeClick(testCases);
    }

    public void clickProducts() {
        safeClick(productsLink);
    }

    public WebElement LocatorHomePageFooter() {
        return homePageFooter;
    }

    public boolean msgSubscription() {
        try {
            waitForVisibilityOfWebelement(subscription);
            return subscription.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void setSubscribeEmail(String email) {
        safeType(subscribeEmail, email);
    }

    public void clickBtnSubscribe() {
        safeClick(btnSubscribe);
    }

    public void clickBtnCart() {
        // prefer direct click, with safeClick wrapper
        safeClick(btnCart);
    }

    public void clickBtnViewProduct4() {
        safeClick(btnViewProduct4);
    }

    public void clickAddToCartProduct1() {
        // use JS click fallback inside safeClick
        safeClick(btnAddToCartProduct1);
    }

    public void clickAddToCartProduct2() {
        safeClick(btnAddToCartProduct2);
    }

    public void clickLnkViewCart() {
        safeClick(lnkViewCart);
    }

    public void clickBtnWomenCategories() {
        safeClick(womenCategories);
    }

    public void clickBtnDressSubWomenCategories() {
        safeClick(dressSubWomenCategories);
    }

    public boolean isMessageDressOnPage() {
        try {
            waitForVisibilityOfWebelement(messageDressOnPage);
            return messageDressOnPage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickBtnMenCategories() {
        safeClick(menCategories);
    }

    public void clickBtnJeansSubMenCategories() {
        safeClick(jeansSubMenCategories);
    }

    public boolean isMessageJeansOnPage() {
        try {
            waitForVisibilityOfWebelement(messageJeansOnPage);
            return messageJeansOnPage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areFooterWebElementsDisplayed() {
        try {
            waitForVisibilityOfWebelement(footerCopyright);
            waitForVisibilityOfWebelement(subscription);
            waitForVisibilityOfWebelement(btnSubscribe);
            return footerCopyright.isDisplayed() && subscription.isDisplayed() && btnSubscribe.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMsgRecommendedItems() {
        try {
            waitForVisibilityOfWebelement(msgRecommendedItems);
            return msgRecommendedItems.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRecommendedItemsContainerDisplayed() {
        try {
            waitForVisibilityOfWebelement(recommendedItemsContainer);
            return recommendedItemsContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddToCartRecommendedProduct4() {
        // Fixed: previously clicked Continue Shopping by mistake.
        safeClick(addToCartRecommendedProduct4);
    }

    public void clickScrollUpArrow() {
        try {
            waitForWebElementToBeClickable(scrollUpArrow);
            scrollUpArrow.click();
        } catch (Exception e) {
            // fallback using Actions
            Actions ac = new Actions(driver);
            ac.click(scrollUpArrow).perform();
        }
    }

    public boolean isMsgFullFledgedDisplayed() {
        try {
            waitForVisibilityOfWebelement(msgFullFledged);
            return msgFullFledged.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getMsgFullFledged() {
        try {
            waitForVisibilityOfWebelement(msgFullFledged);
            return msgFullFledged.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean getmsgAlertSentMailExist() {
        try {
            waitForVisibilityOfWebelement(msgAlertSentMail);
            return msgAlertSentMail.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getMsgAlertSentMail() {
        try {
            waitForVisibilityOfWebelement(msgAlertSentMail);
            return msgAlertSentMail.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public void clickBtnContinueShopping() {
        // prefer safeClick which has JS fallback
        safeClick(btnContinueShopping);
    }

    // convenience accessors for tests that rely on WebElement instances
    public WebElement LocatorMessageDressOnPage() {
        return messageDressOnPage;
    }

    public WebElement LocatorMessageJeansOnPage() {
        return messageJeansOnPage;
    }

    public WebElement LocatorMsgFullFledged() {
        return msgFullFledged;
    }
}
