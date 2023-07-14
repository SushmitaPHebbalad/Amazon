package com.amazon.baseutil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.tyss.abp.util.WebActionUtil;

public class BaseClass {
	public WebDriver driver ;
	public static final int ETO = 20;
	public static final int ITO = 10;
	
	@BeforeClass
	public void launchApplication() {
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in/");
			System.out.println("Application launched successfully");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("Closed browser successfully");
	}
}
