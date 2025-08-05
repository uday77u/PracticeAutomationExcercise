/*
 * Test Case 9: Search Product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
 */
package com.automationExcercise.testCases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationExcercise.BaseTest.BaseClass;
import com.automationExcercise.pageObjects.HomePage;
import com.automationExcercise.pageObjects.ProductsPage;

public class TC009_SearchProduct extends BaseClass{

	@Test(description = "SearchProduct")
    public void VerifySearchProduct() throws InterruptedException {
        HomePage home = new HomePage(driver);
        
        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);
        
       //step 4-5: Click on 'Products' button,Verify user is navigated to ALL PRODUCTS page successfully
        home.clickProducts();
        assertEquals(driver.getTitle(), "Automation Exercise - All Products","Product page title mismatch");
        Reporter.log("Click on 'Products' button,Verify user is navigated to ALL PRODUCTS page successfully");
        
        //step 6-7: Enter product name in search input and click search button, Verify 'SEARCHED PRODUCTS' is visible
        String searchedKey="Shirt".toLowerCase();
        ProductsPage products= new ProductsPage(driver);
        products.setSearchProduct(searchedKey);
        products.clickSubmitSearch();
        assertEquals(products.msgSearchedProductsExist(), true,"msg SearchedProducts is not exist");
        Reporter.log("Enter product name in search input and click search button, Verify 'SEARCHED PRODUCTS' is visible");
        
        //step 8: Verify all the products related to search are visible
        /* Improved alternate
        List<WebElement> searchedProducts = products.getSearchedProducts();
        assertEquals(searchedProducts.size() > 0, true, "No products found for the search.");

        for (WebElement product : searchedProducts) {
            String productName = product.getText().toLowerCase();
            assertEquals(productName.contains("shirt"), true, "Product not matching search: " + productName);
        }
        Reporter.log("All searched products contain the keyword 'shirt'", false);
        */

      //step 8: Verify all the products related to search are visible
        List<WebElement> searchedProducts=products.getSearchedProductsList();
        assertEquals(searchedProducts.size()>0, true,"No products found for the search.");
        
        for(WebElement productContainer: searchedProducts) {
        	String productName=productContainer.getText().toLowerCase();
        	assertEquals(productName.contains(searchedKey), true,"Product not matching search: " + productName+"\tsearchedkey: "+searchedKey);
        }
        Reporter.log(" Verified all the products related to search are visible");
        
        
}
}