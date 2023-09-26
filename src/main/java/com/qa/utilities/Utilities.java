package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;






public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_WAIT_TIME = 10;
	
	public static String randomStringValue() {
		
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}

public static String randomStringGenerator() {
		
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTYUWXYZ";
		
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		
		int length = 7;
		for(int i = 0; i<length;i++) {
			
			int index = random.nextInt(alphabet.length());
			
			char randomchar = alphabet.charAt(index);
			
			buffer.append(randomchar);
			
		}
		 return buffer.toString();
		
	}

public static String randomStringGeneratorValue() {
		
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTYUWXYZ";
		
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		
		int length = 7;
		for(int i = 0; i<length;i++) {
			
			int index = random.nextInt(alphabet.length());
			
			char randomchar = alphabet.charAt(index);
			
			buffer.append(randomchar);
			
		}
		 return buffer.toString();
		
	}

public static String randomString() {
	
              StringBuffer sb = new StringBuffer();
				sb.append("Hello");
				sb.append(" ");
				sb.append("world");
				return sb.toString();
			}

public static String maxString() {	
String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
String numbers = "0123456789";


String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

StringBuilder sb = new StringBuilder();

Random random = new Random();

int length = 100;

for(int i = 0; i < length; i++) {

  int index = random.nextInt(alphaNumeric.length());

  char randomChar = alphaNumeric.charAt(index);

  sb.append(randomChar);
  }

  return sb.toString();
}

public static String randomRemarks() {
	 
	 	
		  String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		  String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		  String numbers = "0123456789";

		  
		  String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		  StringBuilder sb = new StringBuilder();

		  Random random = new Random();

		  int length = 250;

		  for(int i = 0; i < length; i++) {

		    int index = random.nextInt(alphaNumeric.length());

		    char randomChar = alphaNumeric.charAt(index);

		    sb.append(randomChar);
		    }
		  
		    return sb.toString();
		  }

public static Object[][] getTestDataFromExcel(String sheetName) {
	File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TestInputdata\\TierMaster.xlsx");
	XSSFWorkbook workbook = null;
	try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fisExcel);
	}catch(Throwable e) {
		e.printStackTrace();
	}
	
	XSSFSheet sheet = workbook.getSheet(sheetName);
	
	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rows][cols];
	
	for(int i=0;i<rows;i++) {
		
		XSSFRow row = sheet.getRow(i+1);
		
		for(int j=0;j<cols;j++) {
			
			XSSFCell cell = row.getCell(j);
			CellType cellType = cell.getCellType();
			
			switch(cellType) {
			
			case STRING:
				data[i][j] = cell.getStringCellValue();
				break;
			case NUMERIC:
				data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
			case BOOLEAN:
				data[i][j] = cell.getBooleanCellValue();
				break;	
	
			}
			
		}
		
		
	}
	
	return data;
	
}





		
}

	
	