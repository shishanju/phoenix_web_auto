package com.lemon.auto.phoenix.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.lemon.auto.phoenix.base.BastTester;

public class Tester extends BastTester{
	@Test
	public void f() {
		driver.get("https://www.baidu.com/");
		driver.findElement(By.id("kw")).sendKeys("Ñý¾«µÄÎ²°Í");
		driver.findElement(By.id("su")).click();
	}
}
