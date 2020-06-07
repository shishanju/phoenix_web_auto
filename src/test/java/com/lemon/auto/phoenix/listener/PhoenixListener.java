package com.lemon.auto.phoenix.listener;

import java.io.File;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.lemon.auto.phoenix.util.ScreenshotUtil;

public class PhoenixListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.println("---------");
		//ScreenshotUtil.takeScreenshot();
		
		//获得输出目录
		String outputDirectory = tr.getTestContext().getOutputDirectory();
		//获取当前test名称
		String testName = tr.getTestContext().getCurrentXmlTest().getName();
		//截取到最后一个\的索引位置去
		String surefireDir = outputDirectory.substring(0, outputDirectory.lastIndexOf("\\"));
		//保存截图的目录
		String screenshotDir = surefireDir+File.separator+"screenshot" + File.separator+testName;
		
		ScreenshotUtil.takeScreenshot(screenshotDir);
	}
}
