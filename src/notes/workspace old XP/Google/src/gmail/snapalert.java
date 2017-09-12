package gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;		
import org.openqa.selenium.By;		
import org.openqa.selenium.NoAlertPresentException;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		

public class snapalert {				
        		
        public static void main(String[] args) throws NoAlertPresentException {									
        	WebDriver driver;
        	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe"); 
        	
        	driver = new ChromeDriver();
                        		
            driver.get("https://www.snapdeal.com/");
            driver.findElement(By.xpath(".//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div")).click();
            
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]")).click();
            
            
            
            
                                		
            //driver.findElement(By.name("uid")).sendKeys("mngr86125");					
            //driver.findElement(By.name("password")).sendKeys("AnUbUtA");					
            //driver.findElement(By.name("btnLogin")).submit();			
            //driver.findElement(By.linkText("Delete Customer")).click();			
            //driver.findElement(By.name("cusid")).sendKeys("53920");					
            //driver.findElement(By.name("AccSubmit")).submit();			
            		
                // Switching to Alert        
            Alert alert=driver.switchTo().alert();		
            		
            // Capturing alert message.    
            String alertMessage=driver.switchTo().alert().getText();		
            		
            // Displaying alert message		
            System.out.println(alertMessage);
            
           
            		
            // Accepting alert		
           alert.dismiss();	
            driver.quit();
                		
        }		
}			