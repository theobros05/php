package demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class myprogram {
WebDriver driver;
@Test
public void f() throws IOException{
	
	// Set the path of the Firefox driver.

    

			 //System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
			 //driver = new ChromeDriver();

		     

		    // Enter url.

		    //driver.get("http://www.linkedin.com/");

		    //driver.manage().window().maximize();
		    

		   

		    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

public void ReadData() throws IOException

{

    // Import excel sheet.

    File src=new File("D:\\Value.xlsx");

     

    // Load the file.

    FileInputStream finput = new FileInputStream(src);
    
    


Workbook workbook = new XSSFWorkbook(finput);

XSSFWorkbook w = new XSSFWorkbook();



//To get the access to the sheet
XSSFSheet sheet = w.getSheetAt(0);

int colNum = sheet.getLastRowNum();

System.out.println("Total Number of Columns in the excel is : "+colNum);

int rowNum = sheet.getLastRowNum()+1;

System.out.println("Total Number of Rows in the excel is : "+rowNum);


//To get the total no of rows in excel sheet
int rows = sheet.getPhysicalNumberOfRows();

System.out.println(rows);
//To get the total no of columns in excel sheet
int colNumm= sheet.getLastRowNum();

System.out.println(colNum);
/*
for(int i=1;i<rows;i++)
  {
   for (int j=0;j<2;j++)
{
//getting value of second row and first column.(First user name)
String username=sh.getCell(j,i).getContents();
System.out.print(username);
fd.findElement(By.id("txtUsername")).sendKeys(username);
//getting value of second row and seocnd column.(First password)
String password=sh.getCell(++j,i).getContents();
System.out.println("username1");
fd.findElement(By.id("txtPassword")).sendKeys(password);
//To click on login button
fd.findElement(By.id("btn_Login")).click();
//To click on logut button
fd.findElement(By.id("btnSign_Off")).click();
}}}}*/
}}