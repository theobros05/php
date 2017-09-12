package apachertr;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class newread 
{
   static XSSFRow row;
   
   String user;
   public static void main(String[] args) {
	   
	   
	  // System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
   	
       //WebDriver driver = new ChromeDriver(); 
	    try {
	        FileInputStream file = new FileInputStream(new File("D:\\data.xlsx"));
	        

	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        
	        DataFormatter formatter = new DataFormatter();
	        
	       	        
	        int col_num = -1;
	        
	        for(int i=0; i < row.getLastCellNum(); i++)
	        {
	            if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
	                col_num = i;
	        }
	 
	        row = sheet.getRow(1);
	         XSSFCell cell = row.getCell(col_num);
	 
	        String value = cell.getStringCellValue();
	        System.out.println("Value of the Excel Cell is - "+ value);
	        
	        /* int col_num = 0;
	        
	        for (Iterator iterator = sheet.rowIterator(); iterator.hasNext();)
	        {
	            XSSFRow row = (XSSFRow) iterator.next();
	            
	            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) 
	            {
	                Cell cell = row.getCell(i);
	                if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
                        col_num = i;
	                String value = cell.getStringCellValue();
	                System.out.println("Value of the Excel Cell is - "+ value); 
	                
	              
	                
	               
	            }*/
	            
	            
	            
	            //row = sheet.getRow(1);
                //Cell cell = row.getCell(col_num);
         
	            //Cell cel = row.getCell(0);
                //System.out.println(formatter .formatCellValue(cell));
                
                //driver.get("http://www.gmail.com");
                
                
                
	        
	       /* //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext())
	        {
	            Row row = rowIterator.next();
	            //For each row, iterate through all the columns
	            Iterator<Cell> cellIterator = row.cellIterator();

	            while (cellIterator.hasNext()) 
	            {
	                Cell cell = cellIterator.next();
	                //Check the cell type and format accordingly
	                
	                     System.out.printf(new DataFormatter().formatCellValue(cell) +"\t");
	                        
	                    
	                        
	            }
	            ;
	        }*/
	        file.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
   }}