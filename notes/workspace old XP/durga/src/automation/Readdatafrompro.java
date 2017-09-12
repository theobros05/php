package automation;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.Properties;  
import org.openqa.selenium.By;  
import org.openqa.selenium.NoSuchElementException;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;  
import org.testng.annotations.Test;


 public class Readdatafrompro {  
@Test()
 public static void main(String[] args) throws InterruptedException
 {  
	
 try {  
 
 FileInputStream fileInput = new FileInputStream(new File("D://Theo-Durga//workspace//durga//data.properties"));  

 Properties prop = new Properties();  

 prop.load(fileInput);  
 
 System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
 WebDriver driver = new ChromeDriver();  
  
 driver.manage().window().maximize();  

 
 driver.get(prop.getProperty("URL")); 
 Thread.sleep(2000);
 driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click(); 
 driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
 driver.switchTo().frame("candidatecontentframe");
 driver.findElement(By.id("txtemailid")).sendKeys(prop.getProperty("Username"));  
 //Read Password from Properties and send to facebook password text field   
 driver.findElement(By.id("txtpwd")).sendKeys(prop.getProperty("Password")); 
 Thread.sleep(2000);
 driver.findElement(By.id("btnSubmit")).click();  
 Thread.sleep(2000);
 driver.switchTo().frame("contentframe");
// driver.findElement(By.cssSelector(".heading")).click();
 driver.findElement(By.cssSelector(".Row-BG>td>a>img")).click();
 Thread.sleep(1000);
 driver.switchTo().defaultContent();
 driver.switchTo().frame("replacedoccontentframe");


 driver.findElement(By.cssSelector(".btn.btn-upload.btn-file")).click();
 String filename = "D:\\Resume.txt";
 File file = new File(filename);
 
 String path = file.getAbsolutePath();
 
 //driver.get("http://the-internet.herokuapp.com/upload");
 
 driver.findElement(By.cssSelector(".btn.btn-upload.btn-file")).sendKeys(path);
 
 Thread.sleep(3000);
 
 driver.findElement(By.cssSelector("#btnSubmit")).click();
 
String text = driver.findElement(By.cssSelector(".btn.btn-upload.btn-file")).getText();
 Thread.sleep(3000);
 //assertThat(text, is(equals(filename)));
 
 System.out.print("File is uploaded");
 

 //Thread.sleep(1000);
 //driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
 


 /*
 if (driver.getPageSource().contains("Please re-enter your password")) {  
   System.out.println("--- Pass ---");  
 } else {  
   System.out.println("!!!! Fail !!!");  
 } */
 
 /*String filename = prop.getProperty("Resume");
 File file = new File(filename);
 String path = file.getAbsolutePath();
 
 driver.findElement();
 
 driver.findElement(By.id("file-upload


 */

 //Print Properties Values  
 System.out.println("URL    =: " + prop.getProperty("URL"));  
 System.out.println("User name =: " + prop.getProperty("Username"));  
 System.out.println("Password =: " + prop.getProperty("Password"));  
 Thread.sleep(2000);
 // Browser close    
 driver.close();
   
     } catch (FileNotFoundException e) {  
 e.printStackTrace();  
     } catch (IOException e) {  
 e.printStackTrace();  
     } catch (NoSuchElementException e) {  
 e.printStackTrace();  
     }  
   }

	private static void assertThat(String text, boolean equals) {
		// TODO Auto-generated method stub
		
	}  
 }  