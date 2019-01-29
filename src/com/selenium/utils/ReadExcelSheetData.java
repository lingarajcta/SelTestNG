package com.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 
 * @author Lingaraj
 *
 */
public class ReadExcelSheetData {
	static String sheetname;
	static String filename;
	 public ReadExcelSheetData(String fileName,String sheetName){
		this.sheetname=sheetName;
		this.filename=fileName;
		
	}


	//public static Map<String,  Map<String, String>> setMapData() throws IOException {
	 public static Map<String,  String> setMapData() throws IOException {
		String path = "testdata\\"+filename+".xlsx";

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = new XSSFWorkbook(fis);

		//Sheet sheet = workbook.getSheetAt(sheet);
		Sheet sheet = workbook.getSheet(sheetname);

		int lastRow = sheet.getLastRowNum();

		Map<String, Map<String, String>> testdataMap = new HashMap<String, Map<String,String>>();

		Map<String, String> dataMap = new HashMap<String, String>();

		//Looping over entire row
		for(int i=0; i<=lastRow; i++){

			Row row = sheet.getRow(i);

			//1st Cell as Value
			Cell valueCell = row.getCell(1);

			//0th Cell as Key
			Cell keyCell = row.getCell(0);

			String value = valueCell.getStringCellValue().trim();
			String key = keyCell.getStringCellValue().trim();

			//Putting key & value in dataMap
			dataMap.put(key, value);

			//Putting dataMap to excelFileMap
			//testdataMap.put("DataSheet", dataMap);
		}

		//Returning excelFileMap
		//return testdataMap;
		return dataMap;

	}

	//Method to retrieve value
	public String getValue(String key) throws IOException{

		Map<String, String> m = setMapData();//.get("DataSheet");
		String value = m.get(key);

		return value;

	}


}
