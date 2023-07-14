package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tyss.abp.util.WebActionUtil;

public class Product_Page {
	public WebDriver driver;
	WebDriverWait wait;
	public static JavascriptExecutor jsExecutor;

	public Product_Page(WebDriver driver, long ETO) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, ETO);
	}

	/*Product Title Text */
	@FindBy(xpath="//span[@id='productTitle']")
	private WebElement txtProductTitle;

	/*Color Option*/
	private WebElement colorOption(String colorName) {
		String xpath = "//li[contains(@title,'"+colorName+"')]//button";
		return driver.findElement(By.xpath(xpath));
	}

	/*Ram Size Text*/
	private WebElement ramSizeOption(String size) {
		String xpath = "//li[contains(@title,'"+size+"') and (not(@class='swatchUnavailable'))]";
		return driver.findElement(By.xpath(xpath));
	}

	/*Brand Text*/
	@FindBy(xpath="//span[text()='Brand']/parent::td/following-sibling::td/span")
	private WebElement txtBrand;


	/*Product Title Text */
	@FindBy(xpath="//li[contains(@id,'color_name_1')]")
	private WebElement colortxt;

	/**
	 * Description:Method to select Color Of the Product
	 * @author Sushmita
	 * @param color
	 * 
	 */
	private void selectColorOftheProduct(String color) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(colorOption(color))).click();
			System.out.println("Given color "+color+" is selected");
		} catch (Exception e) {
			Assert.fail("Expected color "+color+ " for the product is not present");
		}
	}

	/**
	 * Description: Method to select Ram Size
	 * @author Sushmita
	 * @param size,color
	 * 
	 */
	private void selectRamSize(String size,String color) {
		try {	
			wait.until(ExpectedConditions.elementToBeClickable(ramSizeOption(size))).click();
			System.out.println("Given size "+size+" is selected");
		} catch (Exception e) {
			System.out.println("Expected RAM Size "+size+ " is not present for the color "+color);
			Assert.fail("Expected RAM Size "+size+ " is not present for the color "+color);
		}
	}

	/**
	 * Description:Method to validate Product Page
	 * @author Sushmita
	 * @paramexpectedProdDescription
	 * 
	 */
	public void validateProductPage(String expectedProdDescription) {
		try {
			if(txtProductTitle.getText().equalsIgnoreCase(expectedProdDescription)){
				System.out.println("Product is displayed with the title "+expectedProdDescription);
			}else {
				System.out.println("Product is not displayed with the title "+expectedProdDescription);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Product is not displayed with the title "+expectedProdDescription);
		}
	}

	/**
	 * Description:Method to validate Selected Product Details
	 * @author Sushmita
	 * @param size,color,brandName
	 * 
	 */
	public void validateSelectedProductDetails(String size,String color,String brandName) {
		String actualBrandName = null;
		try {
			selectColorOftheProduct(color);
			selectRamSize(size, color);
			actualBrandName = txtBrand.getText();
			if(actualBrandName.equalsIgnoreCase(brandName)) {
				System.out.println("The product "+brandName+ " is available with color "+color+" and size "+size);
			}

		} catch (Exception e) {
			Assert.fail("Expected brand name "+brandName+ " is not matching with the actual brand name "+actualBrandName);
		}
	}

}