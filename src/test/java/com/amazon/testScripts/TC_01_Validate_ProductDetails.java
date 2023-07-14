package com.amazon.testScripts;

import org.testng.annotations.Test;

import com.amazon.baseutil.BaseClass;
import com.amazon.baseutil.InitializePages;
import com.tyss.abp.pages.Home_Page;

public class TC_01_Validate_ProductDetails extends BaseClass {
	@Test
	public void tc_validateProduct() {
		InitializePages pages = new InitializePages(driver, ETO);

		String item = "iphone 14";
		int count = 3;
		String[] productDetails = {"512 GB","Midnight","Apple"};

		/*Enter a product name to search */
		pages.homePage.searchProduct(item);

		/*Click on product*/
		String prodName=pages.productSearchPage.clkOnAnyProduct(count);

		/*Validate product page*/
		pages.productPage.validateProductPage(prodName);

		/*Validate product details*/
		pages.productPage.validateSelectedProductDetails(productDetails[0], productDetails[1], productDetails[2]);
	}

}

