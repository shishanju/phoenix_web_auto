package com.lemon.auto.phoenix.testcase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.auto.phoenix.base.BastTester;
import com.lemon.auto.phoenix.base.Locator;
import com.lemon.auto.phoenix.util.ExcelUtil;
import com.lemon.auto.phoenix.util.LocatorUtil;
import com.lemon.auto.phoenix.util.PropertiesUtil;

public class RegisterTester extends BastTester {
	
	@Test(dataProvider="getDatas")
	public void test_success(String mobliephone, String password, String pwdconfirm) throws InterruptedException {		
		to("registerUrl");
		type(mobliephone, "手机号输入框");
		type(password, "密码");
		type(pwdconfirm, "验证码");		
		click("登陆按钮");
		Thread.sleep(2000);
		String loginbtn = getText("提示信息");
		Assert.assertNull(loginbtn);
		
	}
	
	@DataProvider
	public Object[][] getDatas() {
		Object[][] datas = ExcelUtil.readExcel("", 1);
		return datas;
	}
	
	public static void main(String[] args) {
		System.out.println(RegisterTester.class.getName());
	}
}
