package gmail;

import org.openqa.selenium.Alert;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		

public class alert {				
        		
        public static void main(String[] args)  throws InterruptedException{									
        	WebDriver driver;
        	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe"); 
        	
        	driver = new ChromeDriver();
                        		
            driver.get("http://demo.guru99.com/V4/");			
                                		
            driver.findElement(By.name("uid")).sendKeys("mngr86125");					
            driver.findElement(By.name("password")).sendKeys("AnUbUtA");					
            driver.findElement(By.name("btnLogin")).submit();			
            driver.findElement(By.linkText("Delete Customer")).click();			
            driver.findElement(By.name("cusid")).sendKeys("34940");					
            driver.findElement(By.name("AccSubmit")).click();	
            Thread.sleep(10000) ;
            		
                // Switching to Alert        
            Alert alert=driver.switchTo().alert();	
            
            //driver.switchTo().alert().sendKeys("I'm checking alert");
            		
            // Capturing alert message.    
            String alertMessage=driver.switchTo().alert().getText();		
            		
            // Displaying alert message		
            System.out.println(alertMessage);
            
            Thread.sleep(1000) ;
            		
            // Accepting alert		
            driver.switchTo().alert().dismiss();
            
            
            Thread.sleep(1000) ;
          
                		
        }		
}			