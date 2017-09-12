package demo;
 
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
 
 public class gmailTest {
  
  WebDriver driver;
    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe"); 
    	
    	driver = new ChromeDriver();
     
    
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
     
   
    return excelOperation.readExcelData("D://Data.xlsx","login");
  
    }
 
 /* //Data provider method for SignUp page 
    @DataProvider(name="signUp")
    public Object[][] signUp() throws IOException{
     
    
    return excelOperation.readExcelData("D://Data.xlsx","signup");

    }*/
 
 }