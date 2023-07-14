package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.abp.util.WebActionUtil;

public class Home_Page {
	public WebDriver driver;
	public long ETO;

	public Home_Page(WebDriver driver, long ETO) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.ETO = ETO;
	}

	/*Search Text Field*/
	@FindBy(id="twotabsearchtextbox")
	private WebElement tbSearch;

	/*Search Button*/
	@FindBy(id="nav-search-submit-button")
	private WebElement btnSearch;

	/**
	 * Description: Method to search a product
	 * @param item
	 */
	public void searchProduct(String item) {	
		new WebDriverWait(driver, ETO).until(ExpectedConditions.visibilityOf(tbSearch));
		System.out.println("Search for "+item);
		tbSearch.sendKeys(item,Keys.ENTER);		
	}	
}
