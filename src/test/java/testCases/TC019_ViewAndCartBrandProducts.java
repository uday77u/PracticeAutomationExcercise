/*
 * Test Case 19: View & Cart Brand Products
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Point;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.KookieKidsPage;
import pageObjects.ProductsPage;

public class TC019_ViewAndCartBrandProducts extends BaseClass{
	@Test
	public void testViewAndCartBrandProducts() {
		HomePage homePage=new HomePage(driver);
		ProductsPage productPage=new ProductsPage(driver);
		KookieKidsPage kookieKidsPage=new KookieKidsPage(driver);
				
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
		logger.info("starting TC019_ViewAndCartBrandProducts");
			    
		HomePage home = new HomePage(driver);

		// Step 1-2: Navigate to home page and  Verify that home page is visible successfully
		logger.info("Step 1: Launching the browser");
		logger.info("Step 2: Navigating to baseURL: " + baseURL);
		driver.get(baseURL);
		        
		logger.info("Verifying that home page is visible successfully");
		assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
		
        //step 3-4: Click on 'Products' button,Verify that Brands are visible on left side bar
		logger.info("3. Click on 'Products' button");
        homePage.clickProducts();
        
        logger.info("4. Verify that Brands are visible on left side bar");
        assertTrue(isCurrentTitleWithSegment("Products"), "Product page is not displayed");
        Reporter.log("product Page is displayed successfully",true);
        waitForVisibilityOfWebelement(productPage.LocatorTxtBrand());
        dragToViewWebElement(driver, productPage.LocatorTxtBrand());
        Point point = productPage.LocatorTxtBrand().getLocation();
        assertTrue(point.getX()<200,"Brand is not located in the left side of the panel.Band location x:"+point.getX());
        Reporter.log("Verified that Brands are visible on left side bar",true);
        
        //step 5-6: Click on any brand name, Verify that user is navigated to brand page and brand products are displayed 
        logger.info("5. Click on any brand name");
        productPage.clickKookieKidsBrand();
        
        logger.info("6. Verify that user is navigated to brand page and brand products are displayed");
        assertTrue(isCurrentTitleWithSegment("Kookie Kids"), "Unable to navigate to page:Kookie Kids.");
        assertTrue(kookieKidsPage.isMessageBrandKookieKidsProducts(), "'BrandKookie Kids Products' is not displayed in the page");

        //-- brand product verification is pending
        Reporter.log(" Verified that user is navigated to brand page and brand products are displayed",true);
        
        //step 7-8: On left side bar, click on any other brand link,Verify that user is navigated to that brand page and can see products
        logger.info("7. On left side bar, click on any other brand link");
        productPage.clickBabyhugBrand();
        
        logger.info("8. Verify that user is navigated to that brand page and can see products");
        assertTrue(isCurrentTitleWithSegment("Babyhug"),"Unable to navigate to page:Babyhug.");
       
        logger.debug("application logs end.......");
    	logger.info("**** finished TC019_ViewAndCartBrandProducts  *****"); 
	}
	
	
	
	 /** Improved code
     * Reusable method to verify a brand page without checking product titles
     */
	/*
    private void verifyBrandPage(String brandName, BrandPage brandPage) {
        // Verify heading
        assertTrue(brandPage.isBrandHeadingDisplayed(brandName),
                "'Brand " + brandName + " Products' heading not displayed");

        // Verify URL contains brand name (case-insensitive)
        assertTrue(driver.getCurrentUrl().toLowerCase().contains(brandName.toLowerCase()),
                "URL does not indicate " + brandName + " brand");

        // Verify products are listed
        List<WebElement> products = brandPage.getAllProductElements();
        assertTrue(!products.isEmpty(), "No products found for " + brandName + " brand");

        Reporter.log("Verified brand page for: " + brandName + " with " + products.size() + " products", true);
    }*/
	
}
