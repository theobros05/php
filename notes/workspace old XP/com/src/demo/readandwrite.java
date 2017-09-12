package demo;
 
import java.io.IOException;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
 
 public class readandwrite {
  
  WebDriver driver;
    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe"); 
    	
    	driver = new ChromeDriver();
    	System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

    
    }
    
 // Test for Login page  
    @Test(dataProvider="login")
    public void f1(String usnm, HashMap data) {

   driver.get("http:www.gmail.com");
   WebElement emailTxt = driver.findElement(By.xpath(".//*[@id='identifierId']"));
   emailTxt.sendKeys(data.get("UserName").toString());
   
   System.out.printf(" email....");
   
   driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
   
   WebElement element1 = driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
   element1.sendKeys(data.get("Password").toString());
   
   System.out.printf(" pasword....");
   
   driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
   
   //WebElement signBtn = driver.findElement(By.id("signIn"));
   //signBtn.click();  
   System.out.println("login completed");
     
    }
    
   /* // Test for SignUp page
    @Test(dataProvider="signUp")
    public void f2(String usnm, HashMap data) {

   driver.get("http:www.gmail.com");
   WebElement createAccountLink = driver.findElement(By.id("link-signup"));
   createAccountLink.click();
   WebElement firstName = driver.findElement(By.id("FirstName"));
   firstName.sendKeys(data.get("FirstName").toString());
   WebElement lastName = driver.findElement(By.id("LastName"));
   lastName.sendKeys(data.get("LastName").toString());
   System.out.printf(" opening page....");
   }*/
    
 // Data provider method for Login page   
    @DataProvider(name="login")
    public Object[][] loginData() throws IOException{
     
    	// Create the input stream for Excel file 
    	
    	FileInputStream fi = new FileInputStream("D:\\Data.xlsx");
    	   //InputStream excelfile = new FileInputStream(path);

    	// Create the XSSF workbook and sheet object/variables
    	   XSSFWorkbook wrkbook = new XSSFWorkbook(fi);
    	   XSSFSheet currentSheet = wrkbook.getSheet("login");
    	 

    	// Get the Last ROW and Column number  
    	   int lastRow = currentSheet.getLastRowNum();
    	   XSSFRow  titleRow = currentSheet.getRow(0);
    	   int lastCol = titleRow.getLastCellNum();
    	// Create an Object variable with size as Number of rows and 2 columns and HashMap for storing excel data

    	// Here we are storing the test case name in first index and row data as HashMap in second index   
    	   Object[][] data = new Object[lastRow][2];
    	   HashMap<String, String> rowdata = new HashMap<String, String>();

    	// Iterate the through the rows and columns to fetch the data   
    	   for(int row=1; row<=lastRow; row++){
    	    XSSFRow currentRow = currentSheet.getRow(row);
    	    Cell firstCell = currentRow.getCell(0);
    	    
    	    for(int col=0; col<lastCol-1; col++){
    	     rowdata.put(titleRow.getCell(col+1).getStringCellValue(), currentRow.getCell(col+1).getStringCellValue());
    	    }
    	    data[row-1][0] = firstCell.getStringCellValue();
    	    data[row-1][1] = rowdata.clone();
    	    rowdata.clear();
    	   }
    	   
    	   
    	   System.out.printf(" reading data....");
    	  return data;
    	  
    	 }
    
  
    }
 
 /* //Data provider method for SignUp page 
    @DataProvider(name="signUp")
    public Object[][] signUp() throws IOException{
     
    
    return excelOperation.readExcelData("D://Data.xlsx","signup");

    }*/
 
 