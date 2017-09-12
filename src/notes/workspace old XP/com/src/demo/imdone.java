package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class imdone 

{public static void main(String[] args) throws IOException, InterruptedException{
	
	WebDriver driver;
	 FileInputStream file = new FileInputStream(new File("D:\\Value.xlsx"));
     

     //Create Workbook instance holding reference to .xlsx file
     XSSFWorkbook workbook = new XSSFWorkbook(file);

     //Get first/desired sheet from the workbook
     XSSFSheet sheet = workbook.getSheetAt(0);
     
     XSSFCell cell;
     XSSFRow  titleRow = sheet.getRow(0);
     
     int col = titleRow.getLastCellNum();
     
   //Get the Last ROW and Column number  
     int row = sheet.getLastRowNum();
     
     System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
     driver=new ChromeDriver();
     driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

     
     System.out.println("Total Number of Columns in the excel is : "+col);
 
     System.out.println("Total Number of Rows in the excel is : "+row);
     
     for(int i=1; i<=row; i++)

     {

         // Import data for Email.

         cell = sheet.getRow(i).getCell(0);

         cell.setCellType(Cell.CELL_TYPE_STRING);

         

         WebElement element =driver.findElement(By.xpath(".//*[@id='identifierId']"));

          element.sendKeys(cell.getStringCellValue());

          driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
          Thread.sleep(5000);

         // Import data for password.

         cell = sheet.getRow(i).getCell(1);

         cell.setCellType(Cell.CELL_TYPE_STRING);
         
         WebElement element1= driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));

         element1.sendKeys(cell.getStringCellValue());
         driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
         Thread.sleep(10000);
         
                 try
                 {
                	 WebElement web1 = driver.findElement(By.xpath("//.//*[@id='password']/div[2]/div[2]"));
                 
                 boolean a2 = web1.isDisplayed();
                 if(a2 = true  ){
                	 cell = sheet.getRow(i).getCell(2); 
                	 cell.setCellValue("fail");
                	file.close(); 
            FileOutputStream fileout =new FileOutputStream(new File("D:\\Value.xlsx")); 
            workbook.write(fileout); 
            fileout.close();
            driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

            System.out.println("test fail"); 
                 }

                	
                 	 
                 }
                 catch(Exception e){
                	 
                	 driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
                     driver.findElement(By.xpath(".//*[@id='gb_71']")).click();
                     driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
                     cell = sheet.getRow(i).getCell(2); 
                     cell.setCellValue("pass");
                     file.close(); 
                     FileOutputStream fileout =new FileOutputStream(new File("D:\\Value.xlsx"));  
                     workbook.write(fileout); 
                     fileout.close();
                     Thread.sleep(1000);
                     System.out.println("test pass"); 

                 }
         
         
  
     }
     
}}


