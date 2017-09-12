 package pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gmailreport{
	
	public static void main(String args[]) throws IOException,FileNotFoundException, InterruptedException{
	
	 FileInputStream file = new FileInputStream(new File("D:\\Data.xlsx"));
     

     //Create Workbook instance holding reference to .xlsx file
     XSSFWorkbook workbook = new XSSFWorkbook(file);

     //Get first/desired sheet from the workbook
     XSSFSheet s = workbook.getSheetAt(0);
     
     
     XSSFRow z = s.getRow(0);
     

    
	
	
}}

