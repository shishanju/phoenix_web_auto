package com.lemon.auto.phoenix.util;

import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.lemon.auto.phoenix.base.Locator;

public class LocatorUtil {
	
	
	public static void main(String[] args) {
		//HashMap<String, HashMap<String, Locator>> pagesMap = loadUiInfo();
		//System.out.println(pagesMap);
		HashMap<String, Locator> locatorsMap = pagesMap.get("com.lemon.auto.phoenix.testcase.RegisterTester");
		Locator locator = locatorsMap.get("手机号输入框");
		System.out.println(locator);
	}
	
	
	private static HashMap<String, HashMap<String, Locator>> pagesMap = new HashMap<String, HashMap<String,Locator>>();

	static {
		loadUiInfo();
	}

	public static HashMap<String, Locator> getPageMapByPageName(String pageName) {
		return pagesMap.get(pageName);
	}
	
	public static Locator getLocator(String pageName, String desc) {
		return pagesMap.get(pageName).get(desc);
	}
	
	public static void loadUiInfo() {
		SAXReader reader = new SAXReader();
		//告诉我一个页面，我能知道这个页面的所有定位信息
		try {
			//得到文档
			Document document = reader.read(LocatorUtil.class.getResourceAsStream("/locators/locators.xml"));
			//得到root标签-->得到pages
			Element rootElement = document.getRootElement();
			//得到所有的子标签--》page--》list
			List<Element> pageElements = rootElement.elements("page");
			//遍历每隔page
			for (Element page : pageElements) {
				//得到每个page的名称
				String pageName = page.attributeValue("name");
				//得到当前页面的所有元素信息
				List<Element> locatorElements = page.elements("locator");
				
	
				//当前这个Map是保留了当前的定位信息
				HashMap<String, Locator> LocatorMap = new HashMap<String, Locator>();
				
				//遍历每个locator元素，得到每个locator对应的定位信息
				for (Element locatorElement : locatorElements) {
					//得到定位方式
					String by = locatorElement.attributeValue("by");
					//得到定位值
					String value = locatorElement.attributeValue("value");
					//得到描述信息
					String desc = locatorElement.attributeValue("desc");
					//System.out.println(by + "," + value + "," + desc);
					//解析出来后包装到另外的数据载体--》方便java代码运行操作
					Locator locator = new Locator(by, value, desc);
					//每个locator要放到某个容器中
					//告诉我一个页面，我能知道所有的定位信息
					//告诉我一个元素描述，我能知道这个的元素对应的定位信息
					LocatorMap.put(desc, locator);
				}
				pagesMap.put(pageName, LocatorMap);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	
/*	public static HashMap<String, HashMap<String, Locator>> lodUiInfo() {
		SAXReader reader = new SAXReader();
		HashMap<String, HashMap<String, Locator>> pageMap = new HashMap<String, HashMap<String,Locator>>();
		try {
			Document document = reader.read(LocatorUtil.class.getResourceAsStream("/locators/locators.xml"));
			//获取得到Page
			Element rootElement = document.getRootElement();
			//得到所有page
			List<Element> pageElements = rootElement.elements("page");		
			//遍历所有的page
			for (Element pageElement : pageElements) {
				//得到page的文本
				String pageName = pageElement.attributeValue("name");
				
				HashMap<String, Locator> locatorMap = new HashMap<String, Locator>();
				//得到所有的locator
				List<Element> pageNames = pageElement.elements("locator");
				for (Element locElement : pageNames) {
					String by = locElement.attributeValue("by");
					String value = locElement.attributeValue("value");
					String desc = locElement.attributeValue("desc");
					//System.out.println(by + "," + value + "," + desc);
					Locator locator = new Locator(by, value, desc);
					
					locatorMap.put(desc, locator);
				}
				
				pageMap.put(pageName, locatorMap);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return pageMap;
	}
	
	*/
	
	

}
