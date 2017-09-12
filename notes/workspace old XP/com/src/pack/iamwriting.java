package pack;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class iamwriting 
{
   
   public static void main(String[] args)  {
	
	   FileInputStream fi = new FileInputStream("D:\\Data.xlsx");
	   XSSFWorkbook w = new XSSFWorkbook(fi);
	   
	   XSSFSheet sheet = w.getSheetAt(0);
	   
	  
	   int z=sheet.getPhysicalNumberOfRows();
	   
	   Row r =sheet.getRow(z);
	   
	   System.out.println("no of rows:"+z);
	   //driver.get("http://www.gmail.com");
	   //for(int row=0; row <=sheet.z;row++)
	   //{
	   //String username = sheet.getCell(0, row).getContents();
	  // System.out.println("Username "+username);
	   //driver.get("http://www.gmail.com");
	
   }}
	   
	   
   
	   