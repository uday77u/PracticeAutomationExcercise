package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//-----------------------------------Locators--------------------------------


@FindBy(xpath="//h2[normalize-space()='All Products']") @CacheLookup private WebElement allProducts;
@FindBy(css = "a[href='/product_details/1']") private WebElement FirstProduct;
@FindBy(xpath="//a[@data-product-id='2']") @CacheLookup private WebElement FirstProductName;
@FindBy(xpath="//p[contains(text(),'Category')]") @CacheLookup private WebElement category;
@FindBy(xpath="//div[@class='product-information']/span") @CacheLookup private WebElement Price;
@FindBy(xpath="//b[text()='Availability:']") @CacheLookup private WebElement availability;
@FindBy(xpath="//b[text()='Condition:']") @CacheLookup private WebElement condition;
@FindBy(xpath="//b[text()='Brand:']") @CacheLookup private WebElement brand;

@FindBy(id = "search_product") private WebElement searchProduct;
@FindBy(id = "submit_search") private WebElement submitSearch;
@FindBy(xpath="//h2[text()='Searched Products']")  private WebElement msgSearchedProducts;

@FindBy(xpath="//a[@data-product-id='1']")  private WebElement btnAddToCartProduct1;
@FindBy(xpath="//a[@data-product-id='3']")  private WebElement btnAddToCartProduct3;
/* Improved
public List<WebElement> getSearchedProducts() {
    return driver.findElements(By.xpath("//div[@class='features_items']//div[@class='productinfo text-center']/p"));
}
*/

@FindBy(xpath = "//div[@class='productinfo text-center']/p")  List<WebElement> searchedProductsList; 

@FindBy(xpath ="//button[normalize-space()='Continue Shopping']" ) public WebElement btnContinueShopping;
@FindBy(xpath="//a[@data-product-id='3' and text()='Add to cart']")  private WebElement btnProduct3AddToCart;
@FindBy(xpath = "//u[text()='View Cart']") public WebElement btnViewCart;
@FindBy(xpath = "//h2[text()='Brands']") private WebElement txtBrand;

@FindBy(xpath = "//a[text()='Kookie Kids']") private WebElement KookieKidsBrand;
@FindBy(xpath = "//a[text()='Babyhug']") private WebElement BabyhugBrand;


@FindBy(xpath ="//a[text()='View Product' and @href='/product_details/2']") private WebElement btnViewProduct2;

//------------------------------Methods------------------------------------------------------
public boolean msgAllProducts() {
	return allProducts.isDisplayed();
}
public void clickFirstProduct() {
	FirstProduct.click();
}
public boolean FirstProductNameExist() {
	return FirstProductName.isDisplayed();
}

public boolean ProductCategoryExist() {
	return category.isDisplayed();
}

public boolean ProductPriceExist() {
	return Price.isDisplayed();
}

public boolean ProductAvailabilityExist() {
	return availability.isDisplayed();
}

public boolean ProductConditionExist() {
	return condition.isDisplayed();
}

public boolean ProductionBrandExist() {
	return brand.isDisplayed();
}

public void setSearchProduct(String productName) {
	searchProduct.sendKeys(productName);
}

public void clickSubmitSearch() {
	submitSearch.click();
}

public boolean msgSearchedProductsExist() {
	return msgSearchedProducts.isDisplayed();
}
public void clickbtnAddToCartProduct1() {
	 //sol1
    //product.clickbtnAddToCartProduct1();
    
    //sol2
    //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
    //wait.until(ExpectedConditions.elementToBeClickable(product.LocatorBtnAddToCartProduct1()));
    //product.clickbtnAddToCartProduct1();
    
    //sol3
    //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product.LocatorBtnAddToCartProduct1());
    //product.LocatorBtnAddToCartProduct1().click();
    
    //final soln
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", LocatorBtnAddToCartProduct1());
    
}

public WebElement LocatorBtnAddToCartProduct1() {
	return btnAddToCartProduct1;
}
public List<WebElement> getSearchedProductsList() {
	return searchedProductsList;
}
public void clickBtnContinueShopping() {
	btnContinueShopping.click();
}
public WebElement LocatorBtnAddToCartProduct3() {
	return btnAddToCartProduct3;
}
public void clickBtnProduct3AddToCart() {
	btnProduct3AddToCart.click();
}
public void clickBtnViewCart() {
	btnViewCart.click();
}
public boolean isTxtBrandVisible() {
	return txtBrand.isDisplayed();
}
public WebElement LocatorTxtBrand() {
	return txtBrand;
}
public void clickKookieKidsBrand() {
	KookieKidsBrand.click();
}
public void clickBabyhugBrand() {
	BabyhugBrand.click();
}

public void clickBtnViewProduct2() {
	btnViewProduct2.click();
}



}
