package obj1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assertion {
	
	public static void main(String[] args) 
	{
  
		String Title;
 
        //initialize Chrome driver
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    	
        WebDriver driver = new ChromeDriver(); 
        
     
        
        driver.get("http://www.techfetch.com");
        
        Title = driver.getTitle();
        
        System.out.println("ActualTitle is  " + Title );
        
         //driver.navigate().to("http://www.techfetch.com/");
          
       
       
       Assert.assertEquals(Title, driver.getTitle());
    
       System.out.println("Successfully passed!");
       
       
       driver.navigate().to("http://www.google.com");
       
       
             
       
 
      
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   
    
         
       
}}


    































