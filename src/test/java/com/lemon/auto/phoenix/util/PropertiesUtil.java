package com.lemon.auto.phoenix.util;

import java.util.Properties;

import com.lemon.auto.phoenix.testcase.RegisterTester;

/**
 * 属性文件工具类
 * @author admin
 *
 */
public class PropertiesUtil {

	private static Properties urlProperties = new Properties();

	static {
		//url属性文件
		LoadUrlProperties();
	}
	
	public static void LoadUrlProperties() {
		try {
			urlProperties.load(PropertiesUtil.class.getResourceAsStream("/url.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//根据指定的Key获得url
	public static String getUrl(String key) {
		return urlProperties.getProperty(key);
	}
}
