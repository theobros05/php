

package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Durgademo {
WebDriver driver;
private static final String FILE_NAME = "D:\\Value.xlsx";



@Test
public void read() throws IOException
{
FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));

Workbook workbook = new XSSFWorkbook(excelFile);

XSSFWorkbook w = new XSSFWorkbook();
XSSFSheet spreadsheet = w.createSheet("SHEET");
//XSSFRow row = spreadsheet.createRow(0);
Row row=spreadsheet.getRow(0);



try {
System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");



//System.out.println(workbook.getSheetAt(0).getRow(1).getCell(0));
for(int i=1;i<3;i++)
{
//for(int j=1;j<2;j++){
String s=String.valueOf(workbook.getSheetAt(0).getRow(i).getCell(0));


//System.out.println(b);

WebElement element =driver.findElement(By.xpath(".//*[@id='identifierId']"));

element.sendKeys(s);
driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
Thread.sleep(5000);
int j=i;

String b=String.valueOf(workbook.getSheetAt(0).getRow(j).getCell(1));
WebElement element1= driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));

element1.sendKeys(b);


spreadsheet.getRow(i).createCell(3).setCellValue("message");

driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();

String p=driver.getCurrentUrl();

System.out.println(p);

String sr="https://accounts.google.com/signin/v2/sl/pwd?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward";
if(p.equals(sr))
{
	/*for(int z = 1; z <= 2; z++) {
	    Row r = spreadsheet.getRow(z);
	    Cell cell = r.getCell(2);
	    if (cell == null) {
	        cell = r.createCell(2);
	    }*/
	
	
	/*Cell c1=spreadsheet.getRow(4).createCell(2);
	   c1.setCellType(Cell.CELL_TYPE_STRING);
	    c1.setCellValue("some value");*/
	
	Row r = spreadsheet.getRow(9); // 10-1
	if (r == null) {
	   // First cell in the row, create
	   r = spreadsheet.createRow(9);
	}
	Cell c1=spreadsheet.getRow(4).createCell(2);
	   c1.setCellType(Cell.CELL_TYPE_STRING);
	    c1.setCellValue("some value");
	/*Cell c = r.getCell(3); // 4-1
	if (c == null) {
	    // New cell
	    c = r.createCell(3, Cell.CELL_TYPE_NUMERIC);
	}
	c.setCellValue(100);
	    /*FileOutputStream fos = new FileOutputStream("D:\\Value.xlsx");
	    workbook.write(fos);
	    fos.close();*/
	

    System.out.println("fail");
    

}

else
{
	System.out.println("pass");
}


//write code to append.

//String c =String.valueOf(workbook.getSheetAt(0).getRow(i).getCell(3));


Thread.sleep(10000);
driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
driver.findElement(By.xpath(".//*[@id='gb_71']")).click();


//driver.findElement(By.xpath(".//*[@id='view_container']/form/div[1]/div/div/div[2]/div/content/span/span/svg")).click();
//driver.findElement(By.xpath(".//*[@id='identifierLink']/div[2]/p")).click();
driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");


driver.quit();
}
}
catch(Exception e)

{
}

}
/*@AfterTest
public void excelwrite() throws Exception {
	  try {
	   //FileInputStream file = new FileInputStream(new File(
	     //"D:\\Book1.xlsx"));

	   XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("cell types");
	      XSSFRow row = spreadsheet.createRow((short) 2);
	      row.createCell(3).setCellValue("Type of Cell");
	    FileOutputStream File = new FileOutputStream(new File("D:\\Book1.xlsx"));
	   workbook.write(File);
	   File.close(); 
	  }
	  
	  



catch(Exception e)

{
}


}*/

}
