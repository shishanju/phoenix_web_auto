package com.lemon.auto.phoenix.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumUtil {
	
	public static final String IE_BROWSER_NAME = "ie";
	
	public static final String CHROME_BROWSER_NAME = "chrome";
	
	public static final String FIREFOX_BROWSER_NAME = "firefox";

	public static WebDriver getWebDriver(String browserType, String driverPath) {
		if (IE_BROWSER_NAME.equalsIgnoreCase(browserType)) {
			return getIEDriver(driverPath);
		}else if (CHROME_BROWSER_NAME.equalsIgnoreCase(browserType)) {
			return getChromeDriver(driverPath);
		}else if (FIREFOX_BROWSER_NAME.equalsIgnoreCase(browserType)) {
			return getFirefoxDriver(driverPath);
		}
		return null;
	}

	private static WebDriver getFirefoxDriver(String driverPath) {
		System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, driverPath);
		return new FirefoxDriver();
	}

	private static WebDriver getChromeDriver(String driverPath) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, driverPath);
		return new ChromeDriver();
	}

	private static WebDriver getIEDriver(String driverPath) {
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, driverPath);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		return new InternetExplorerDriver(capabilities);
	}

}
