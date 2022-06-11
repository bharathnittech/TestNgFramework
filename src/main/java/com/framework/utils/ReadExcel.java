package com.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String [][] readData(String workbook,String sheet){
		String [][] data = null;
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+workbook);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh= wb.getSheet(sheet);
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			data = new String [totalRows-1][totalColumns];
			
			for(int i=1; i<totalRows;i++) {
				for(int j=0;j<totalColumns;j++) {
					data[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
				}
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}

}
