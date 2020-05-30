package com.lemon.auto.phoenix.testcase;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.auto.phoenix.base.BastTester;
import com.lemon.auto.phoenix.base.Locator;
import com.lemon.auto.phoenix.util.ExcelUtil;
import com.lemon.auto.phoenix.util.LocatorUtil;

public class Register_Failure_Tester extends BastTester {

	@Test
	public void f() {
		
		driver.get("");
		
	}
	
	@Test(dataProvider="getDatas")
	public void test_all(String mobliephone, String password, String pwdconfirm, String tips) {
		
		getElement("手机号输入框").sendKeys(mobliephone);
		getElement("密码").sendKeys(password);
		getElement("验证码").sendKeys(pwdconfirm);
		String text = getElement("提示信息").getText();
		Assert.assertEquals(tips, text);
	}
	
	@DataProvider
	public Object[][] getDatas() {
		Object[][] datas = ExcelUtil.readExcel("", 1);
		return datas;
	}
}
