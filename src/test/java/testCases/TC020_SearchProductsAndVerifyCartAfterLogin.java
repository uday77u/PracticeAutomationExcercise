/*
 * Test Case 20: Search Products and Verify Cart After Login
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.BaseClass;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;

public class TC020_SearchProductsAndVerifyCartAfterLogin extends BaseClass {

	@Test
	public void testSearchProductsAndVerifyCartAfterLogin() {
		HomePage homePage=new HomePage(driver);
		ProductsPage productsPage=new ProductsPage(driver);
		CartPage cartPage=new CartPage(driver);
		
		// Step 1-2: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, true);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\n Navigate to home page and verified", true);
        
        //step 3-4: Click on 'Products' button, Verify user is navigated to ALL PRODUCTS page successfully
         homePage.clickProducts();
         assertTrue(isCurrentTitleWithSegment("All Products"),"Unable to navigated to ALL PRODUCTS page");
        Reporter.log("Verified user is navigated to ALL PRODUCTS page successfully");
        
        //step 5-6: Enter product name in search input and click search button, Verify 'SEARCHED PRODUCTS' is visible
        String searchedKey="Top";
        productsPage.setSearchProduct(searchedKey);
        productsPage.clickSubmitSearch();
        assertTrue(productsPage.msgSearchedProductsExist(),"'searched products' message is not visible");
        
       //step 7: Verify all the products related to search are visible
        SoftAssert sa=new SoftAssert();
        List<WebElement> displayedProductList = productsPage.getSearchedProductsList();
        sa.assertTrue(displayedProductList.size()>0,"No searched products found");
        Reporter.log("Total displayed products: "+displayedProductList.size(),true);        
        for (WebElement displayedProduct : displayedProductList) {
        	String displayedProductName = displayedProduct.getText().toLowerCase();
        	sa.assertTrue(displayedProductName.contains(searchedKey.toLowerCase()), "Mis match in displayed product:"+displayedProductName+" and searched product:"+searchedKey);
        }
        sa.assertAll();
        Reporter.log("all search related products are displayed");
        
       //step 8-9: Add those products to cart, Click 'Cart' button and verify that products are visible in cart
        
        
       //step 10: Click 'Signup / Login' button and submit login details
        
       //step 11-12: Again, go to Cart page,Verify that those products are visible in cart after login as well
        
        
        
	}
}
