package com.lemon.auto.phoenix.base;

import org.testng.annotations.Test;

import com.lemon.auto.phoenix.util.SeleniumUtil;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class BastTester {

	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters(value= {"browserType","driverPath"})
	public void beforeSuite(String browserType, String driverPath) {
		driver = SeleniumUtil.getWebDriver(browserType, driverPath);
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	public WebElement getElement(long timeOutInSeconds, final By by) {
		WebDriverWait wait =  new WebDriverWait(driver, 3);
		wait.until(new ExpectedCondition<WebElement>() {


			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(by);
			}
		});
		return null;
	}
		
		public WebElement getElement(final By by) {
			return getElement(5, by);
		}
}
