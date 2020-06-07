package com.lemon.auto.phoenix.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.lemon.auto.phoenix.base.BastTester;


public class ScreenshotUtil {
	
	public static void takeScreenshot(String screenshotDir) {
		
	
	//拿到driver
	WebDriver driver = BastTester.driver;
	//强转位截图类型
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	//拿到了截图文件对象
	File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	//获得毫秒值
	long time = new Date().getTime();
	String fileName = time + ".jpg";
	//创建一个目录文件对象
	File destFile = new File(screenshotDir+File.separator + fileName);
	try {
		FileUtils.copyFile(screenshotFile, destFile);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
