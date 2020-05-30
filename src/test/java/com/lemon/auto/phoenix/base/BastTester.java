package com.lemon.auto.phoenix.base;

import org.testng.annotations.Test;

import com.lemon.auto.phoenix.testcase.RegisterTester;
import com.lemon.auto.phoenix.util.LocatorUtil;
import com.lemon.auto.phoenix.util.PropertiesUtil;
import com.lemon.auto.phoenix.util.SeleniumUtil;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class BastTester {

	public static WebDriver driver;
	
	private static Logger logger= Logger.getLogger(BastTester.class);
	
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
		
		
		public WebElement getElement(String keyword) {
			return getElement(5, keyword);
		}
		
		
		public WebElement getElement(long timeOutInSeconds, String keyword) {
			HashMap<String, Locator> locatorMap = LocatorUtil.getPageMapByPageName(this.getClass().getName());
			
			Locator locator = locatorMap.get(keyword);
			//定位方式
			final String byStr = locator.getBy();
			//定位值
			final String value = locator.getValue();
			WebDriverWait wait =  new WebDriverWait(driver, 3);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver driver) {
					By by = null;
	/*				if ("id".equals(byStr)) {
						by = By.id(value);
					}else if ("name".equals(byStr)) {
						by = By.name(value);
					}else if ("xpath".equals(byStr)) {
						by = By.xpath(value);
					}else if ("cssSelector".equals(byStr)) {
						by = By.cssSelector(value);
					}else if ("linkText".equals(byStr)) {
						by = By.linkText(value);
					}else if ("partialLinkText".equals(byStr)) {
						by = By.partialLinkText(value);
					}else if ("tagName".equals(byStr)) {
						by = By.tagName(value);
					}else if ("className".equals(byStr)) {
						by = By.className(value);
					}*/
							
					try {
						//拿到字节码对象
						Class<By> clazz = By.class;
						//获取方法名
						Method byMethod = clazz.getMethod(byStr, String.class);
						//调用by方法
						by = (By)byMethod.invoke(null, value);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return driver.findElement(by);
				}
			});
			return null;
		}
		
		/**
		 * 输入内容
		 * @param content
		 * @param keyword
		 */
		public void type(String content, String keyword) {
			logger.info("正在往 ["+ keyword +"] " + "输入内容为 + ["+ content +" ]");
			getElement(keyword).sendKeys(content);
		}
		
		/**
		 * 点击按钮
		 * @param keyword
		 */
		public void click(String keyword) {
			logger.info("正在点击 ["+ keyword +"] ");
			getElement(keyword);
		}
		
		/**
		 * 获取元素文本
		 * @param keyword
		 * @return  
		 */
		public String getText(String keyword) {
			logger.info("正在获取 ["+ keyword +"] " + "的文本");
			return getElement(keyword).getText();
		}
		
		/**
		 * 获取url
		 * @param Strkey
		 */
		public void to(String Strkey) {
			driver.get(PropertiesUtil.getUrl("baseUrl") + PropertiesUtil.getUrl(Strkey));
		}
}
