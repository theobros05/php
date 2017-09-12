package gmail;
 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.openqa.selenium.firefox.*;
import java.util.concurrent.*;
import org.testng.annotations.Test;
public class Signin {
	
	WebDriver driver;
	
	
    @Test (groups ={"login"})
    public void testCase1()
    {
     	
 
        //initialize Chrome driver
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    	
        WebDriver driver = new ChromeDriver(); 
 
         //Open gmail
         driver.get("http://www.gmail.com");
 
         // Enter userd id
         WebElement element = driver.findElement(By.xpath(".//*[@id='identifierId']"));
         element.sendKeys("");
         
         // to click next button
         driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
         
       //wait 5 secs for  userid to be entered
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 
         //Enter Password
         WebElement element1 = driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
         element1.sendKeys(""); 
      // to click next button in password
         driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
         System.out.println("login completed");
    }
    
   
        
         // to dynamically find elements
      @Test  (groups ={"logout"})   
      public void testCase2()
      {   
        
        WebElement myDynamicElement = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")));
         driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
        
         //press signout button
         driver.findElement(By.xpath(".//*[@id='gb_71']")).click();   
       
   }
      
 
    }
 
