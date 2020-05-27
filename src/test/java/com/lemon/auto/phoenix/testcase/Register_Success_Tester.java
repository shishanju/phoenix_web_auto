package com.lemon.auto.phoenix.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.auto.phoenix.base.BastTester;

public class Register_Success_Tester extends BastTester {

	@BeforeMethod
	public void eforeMethod() {
		driver.get("http://www.baidu.com");
		
	}
	
	@Test(dataProvider="getDatas")
	public void test_success(String mobliephone, String password, String pwdconfirm) throws InterruptedException {
		getElement(By.id("")).sendKeys("");
		getElement(By.id("")).sendKeys("");
		getElement(By.id("")).sendKeys("");
		Thread.sleep(2000);
		WebElement loginbtn = driver.findElement(By.id("bth"));
		Assert.assertNull(loginbtn);
		
	}
	
	@DataProvider
	public Object[][] getDatas() {
		Object[][] datas = {{"1","10",""},
							{"2","20","12"},
							{"3","30","123"},
							{"4","40","1234"},
							{"5","50",""}};
		return datas;
	}
}
