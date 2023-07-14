package com.amazon.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.baseutil.BaseClass;
import com.tyss.abp.util.WebActionUtil;

public class ProductSearch_Page {
	public WebDriver driver;
	public long ETO;
	WebDriverWait wait ;

	public ProductSearch_Page(WebDriver driver, long ETO) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, ETO);
	}


	/*Product Name Text */
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> lstProductName;	
	//span[text()='Results']/ancestor::div/descendant::span[@class='a-size-medium a-color-base a-text-normal']

	/*Results Text*/
	@FindBy(xpath="//span[text()='Results']")
	private WebElement txtResults;


	/**
	 * Description:Method to click on any product
	 * @author Sushmita
	 */
	public String clkOnAnyProduct(int count) {
		wait.until(ExpectedConditions.visibilityOf(txtResults));
		String txtProdName=lstProductName.get(count).getText();
		lstProductName.get(count).click();
		System.out.println("Clicked on the product "+txtProdName);	
		switchToTab();
		driver.manage().timeouts().implicitlyWait(BaseClass.ITO, TimeUnit.SECONDS);
		return txtProdName;
	}

	/**
	 * Description:Method to switch To tab
	 * @author Sushmita
	 */
	public void switchToTab() {
		String mainWindowID = driver.getWindowHandle();
		Set<String> allWindowID = driver.getWindowHandles();
		for (String id : allWindowID) {
			if (!id.equals(mainWindowID)) {
				driver.switchTo().window(id);
			}
		}
	}
}
