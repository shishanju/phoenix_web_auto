package com.lemon.auto.phoenix.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.auto.phoenix.base.BastTester;

public class Register_Failure_Tester extends BastTester {

	@Test
	public void f() {
		
		driver.get("");
		
	}
	
	@Test(dataProvider="getDatas")
	public void test_all(String mobliephone, String password, String pwdconfirm) {
		getElement(By.id("")).sendKeys("");
		getElement(By.id("")).sendKeys("");
		getElement(By.id("")).sendKeys("");
		String expectesResult = "ÃÜÂë²»Ò»ÖÂ";
//		String actualResult = getElement(By.id(""));
		Assert.assertEquals(false, true);
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
