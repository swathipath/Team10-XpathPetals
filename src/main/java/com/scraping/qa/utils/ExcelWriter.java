package com.scraping.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
public void writingDataToExcel(String data,int  rownumber,String sheetName) throws IOException {
	
	int columnStart;
	//Cell cell = null;
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\scrapingData4.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownumber);
	
	int totalColumn = row.getLastCellNum();
	
	
	Cell cell=row.getCell(totalColumn);
	if(cell==null) {
		 cell = row.createCell(totalColumn);
		 cell.setCellValue(data);
	}
	else {
		
			cell.setCellValue(data);
			
		
		}
		
		
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\scrapingData4.xlsx");
		workbook.write(fos);
		fos.close();
		
		
			
		}
		
		


	}


