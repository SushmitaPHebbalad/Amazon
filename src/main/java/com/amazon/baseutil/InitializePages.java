package com.amazon.baseutil;

import org.openqa.selenium.WebDriver;

import com.amazon.pages.Home_Page;
import com.amazon.pages.ProductSearch_Page;
import com.amazon.pages.Product_Page;

public class InitializePages {
	public Home_Page homePage;
	public Product_Page productPage;
	public ProductSearch_Page productSearchPage;

	public InitializePages(WebDriver driver, long ETO) {
		homePage = new Home_Page(driver, ETO);
		productSearchPage = new ProductSearch_Page(driver, ETO);
		productPage = new Product_Page(driver, ETO);

	}
}
