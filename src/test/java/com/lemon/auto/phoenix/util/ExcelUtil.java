package com.lemon.auto.phoenix.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.bcel.generic.NEW;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	
	public static void main(String[] args) {
		//Object[][] datas = ExcelUtil.readExcel("/testcase/testcase.xlsx", 1);
	}

	
	public static Object[][] readExcel(String excelPath, int sheetIndex){
		//创建一个二维数组
		Object[][] datas = null;
		try {
			InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			Workbook workbook = WorkbookFactory.create(inp);
			//获取所需要的sheet
			Sheet sheet = workbook.getSheetAt(sheetIndex - 1); 
			//得到所有的行，从0开始
			int lastRowNum = sheet.getLastRowNum();
			//把得到的值放在二维数组中
			datas = new Object[lastRowNum][];
			//循环遍历所有的行
			for (int i = 1; i <= lastRowNum; i++) {
				//得到每一列
				Row row = sheet.getRow(i);
				//得到每一列从1开始
				int lastCellNum = row.getLastCellNum();
				//创建一个一维数组把值放进去
				Object[] cellValueArray = new Object[lastCellNum];
				//遍历每一列的值
				for (int j = 0; j < lastCellNum; j++) {
					 Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					 //设置每一列的属性
					 cell.setCellType(CellType.STRING);
					 //得到cellValue
					 String cellValue = cell.getStringCellValue();
					 //System.out.println(cellValue + ",");
					 //赋值给一维数组
					cellValueArray[j] = cellValue;
				}
				datas[i - 1] = cellValueArray;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}
	
//	public static Object[][] readExcel(String excelPath, int sheetIndex, int startRow, int endRow, int startCell, int endCell) {
//		Object[][] datas = new Object[endRow-startRow+1][endCell-startCell+1];
//		try {
//			InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
//			Workbook workbook = WorkbookFactory.create(inp);
//			Sheet sheet = workbook.getSheetAt(sheetIndex - 1);
//			
//			for (int i = startRow; i <= endRow; i++) {
//				Row row = sheet.getRow(i - 1);
//				for (int j = startCell; j <= endCell; j++) {
//					Cell cell = row.getCell(j - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
//					cell.setCellType(CellType.STRING);
//					String  cellValue = cell.getStringCellValue();
//					System.out.println(cellValue+ ",");
//					datas[i-startRow][j-startCell] = cellValue;
//				}
//				System.out.println();
//			}
//			
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return datas;
//	}
	

/*	public static Object[][] readExcel(String excelPath, int sheetIndex) {
		Object[][] datas = null;
		try {
			InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			Workbook workbook = WorkbookFactory.create(inp);
			//获取所用的sheet
			Sheet sheet = workbook.getSheetAt(sheetIndex - 1);
			//得到所有行，从0开始
			int lastRowNum = sheet.getLastRowNum();
			//添加到二位数组
			datas = new Object[lastRowNum][];
			//遍历所有行
			for (int i = 1; i <= lastRowNum; i++) {
				//得到每一列
				Row row = sheet.getRow(i);
				//得到所有列，从1开始
				int getLastCellNum = row.getLastCellNum();
				//new一个一维数组，把值存储进去
				Object[] cellValueArray = new Object[getLastCellNum];
				//遍历所有列
				for (int j = 0; j < getLastCellNum; j++) {
					Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String  cellValue = cell.getStringCellValue();
					System.out.println(cellValue+ ",");
					//datas[][j] = cellValue;
					cellValueArray[j] = cellValue;
				}
				System.out.println();
				datas[i - 1] = cellValueArray;
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}*/

/*	public static Object[][] readExcel1(String excelPath, int sheetIndex) {
		InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
		Object[][] datas = null;
		try {
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheetAt(sheetIndex -1);
			int lastRowNum = sheet.getLastRowNum();
			datas = new Object[lastRowNum][];
			for (int i = 1; i <= lastRowNum; i++) {
				Row row = sheet.getRow(i);
				int lastCekllNum = row.getLastCellNum();
				Object[] cellValueArray = new Object[lastCekllNum];
				for (int j = 0; j < lastCekllNum; j++) {
					Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String cellValue = cell.getStringCellValue();
					System.out.println(cellValue + ",");
					cellValueArray[j] = cellValue;
				}
				datas[i - 1] = cellValueArray;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	*/

}
