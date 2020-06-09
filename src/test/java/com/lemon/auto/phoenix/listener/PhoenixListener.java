package com.lemon.auto.phoenix.listener;

import java.io.File;

import org.testng.ITestResult;
import org.testng.Reporter;
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
		//得到截图的目标文件
		File screenshotFile = ScreenshotUtil.takeScreenshot(screenshotDir);
		//得到截图文件的绝对路径
		String absolutePath = screenshotFile.getAbsolutePath();

		String oldStr = absolutePath.substring(0,absolutePath.indexOf("screenshot"));
		//在绝对路径中，用http://127.0.0.1：7777 替换上面的oldStr
		String baseUrl = "http://127.0.0.1：7777";
		//替换
		String tempUrl = absolutePath.replace(oldStr,baseUrl);
		//
		String imgUrl = tempUrl.replace("\\","/");
		Reporter.log("<img src='"+imgUrl+"' hight='100' width='100'><a href='"+imgUrl+"' target='_blank'>点击查看大图</a></img>");
	}
}
