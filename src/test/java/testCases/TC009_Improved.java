package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductsPage;

public class TC009_Improved extends BaseClass {
	@Test(description = "SearchProduct")
	public void VerifySearchProduct() throws InterruptedException {
	    logger.debug("logging started");
	    logger.info("***** TC009_SearchProduct *****");

	    try {
	        HomePage home = new HomePage(driver);

	        // Step 1-3: Navigate to home page and verify
	        logger.info("Step 1: Launching browser and navigating to: " + baseURL);
	        driver.get(baseURL);

	        logger.info("Step 2: Verifying home page title");
	        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");

	        // Step 4-5: Navigate to All Products page
	        logger.info("Step 3: Clicking on 'Products' button");
	        home.clickProducts();

	        logger.info("Step 4: Verifying ALL PRODUCTS page title");
	        assertEquals(driver.getTitle(), "Automation Exercise - All Products", "Product page title mismatch");

	        // Step 6: Search for product
	        String searchTerm = "Shirt";
	        String searchTermLower = searchTerm.toLowerCase();

	        logger.info("Step 5: Searching for product: " + searchTerm);
	        ProductsPage products = new ProductsPage(driver);
	        products.setSearchProduct(searchTerm);
	        products.clickSubmitSearch();

	        // Step 7: Verify SEARCHED PRODUCTS section
	        logger.info("Step 6: Verifying 'SEARCHED PRODUCTS' section is visible");
	        assertTrue(products.msgSearchedProductsExist(), "'SEARCHED PRODUCTS' is not visible");

	        // Step 8: Verify all search results contain the keyword
	        logger.info("Step 7: Verifying all search results contain: " + searchTermLower);
	        List<WebElement> searchedProducts = products.getSearchedProductsList();
	        assertTrue(searchedProducts.size() > 0, "No products found for the search.");

	        for (WebElement productContainer : searchedProducts) {
	            String productName = productContainer.getText().toLowerCase();
	            assertTrue(productName.contains(searchTermLower),
	                "Product not matching search: " + productName + " | expected to contain: " + searchTermLower);
	        }

	        logger.info("Step 8: All products match the searched keyword");

	    } catch (Throwable t) {
	        logger.error("Test failed", t);
	        Assert.fail("Failure occurred: " + t.getMessage());
	    }

	    logger.debug("application logs end.......");
	    logger.info("**** finished TC009_SearchProduct *****");
	}


}
