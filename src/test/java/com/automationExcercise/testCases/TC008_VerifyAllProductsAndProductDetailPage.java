/*
 * Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
 */

package com.automationExcercise.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationExcercise.BaseTest.BaseClass;
import com.automationExcercise.pageObjects.HomePage;
import com.automationExcercise.pageObjects.ProductsPage;

public class TC008_VerifyAllProductsAndProductDetailPage extends BaseClass{
	
	@Test(description = "Verify all products and product Detail Page")
    public void VerifyAllProductsAndProductDetailPage() throws InterruptedException {
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
        
        //step 6: The products list is visible
        ProductsPage product=new ProductsPage(driver);
        assertEquals(product.msgAllProducts(), true,"Products list is not visible");
        Reporter.log("The products list is visible");
        
        //step 7-8: Click on 'View Product' of first product, User is landed to product detail page
        product.clickFirstProduct();
        assertEquals(driver.getTitle(), "Automation Exercise - Product Details","Product page title mismatch");
        Reporter.log("Click on 'View Product' of first product, User is landed to product detail page");
        
        //step 9: Verify that detail detail is visible: product name, category, price, availability, condition, brand
        assertEquals(product.FirstProductNameExist(),true,"Product name is not exist");
        assertEquals(product.ProductCategoryExist(),true,"Product category is not exist");
        assertEquals(product.ProductPriceExist(),true,"Product price is not exist");
        assertEquals(product.ProductAvailabilityExist(),true,"Product availability is not exist");
        
        assertEquals(product.ProductConditionExist(),true,"Product condition is not exist");
        assertEquals(product.ProductionBrandExist(),true,"Product brand is not exist");
        Reporter.log(" Verified that detail is visible: product name, category, price, availability, condition, brand");
        
        

}
}
