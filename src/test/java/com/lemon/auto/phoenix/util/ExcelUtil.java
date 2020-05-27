package com.lemon.auto.phoenix.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
//
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
	
	public static Object[][] readExcel(String excelPath, int sheetIndex){
		Object[][] datas = null;
		try {
			InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheetAt(sheetIndex - 1); 
			int lastRowNum = sheet.getLastRowNum();
			datas = new Object[lastRowNum][];
			for (int i = 1; i <= lastRowNum; i++) {
				Row row = sheet.getRow(i);
				int lastCellNum = row.getLastCellNum();
				Object[] cellValueArray = new Object[lastCellNum];
				for (int j = 0; j < lastCellNum; j++) {
					 Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					 cell.setCellType(CellType.STRING);
					 String cellValue = cell.getStringCellValue();
					 System.out.println(cellValue + ",");
					cellValueArray[j] = cellValue;
				}
				datas[i - 1] = cellValueArray;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	
	
	public static void main(String[] args) {
		Object[][] datas = ExcelUtil.readExcel("/testcase/订单详情.xlsx", 1);
	}
}
