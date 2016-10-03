package com.system;



import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetConfigue {
	public XSSFWorkbook wb;
	
	public XSSFSheet Sheet1;
	
	public ExcelSheetConfigue(String ExcelSheet){
		
		
		try{
			
			File  src=new File(ExcelSheet);
			
			FileInputStream  fis=new FileInputStream(src);
			
			  wb=new XSSFWorkbook(fis);
			
			
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			}
	}
	
	public String getData(int SheetNumber, int Rows, int col){
		
	Sheet1=wb.getSheetAt(SheetNumber);
	
	String data=Sheet1.getRow(Rows).getCell(col).getStringCellValue();
	
	return data;
		
	}
	
	public int getRowCount(int SheetIndex){
		
		int Row=wb.getSheetAt(SheetIndex).getLastRowNum();
		
	Row=Row+1;
	
	return Row;
	}
		
	}
	
