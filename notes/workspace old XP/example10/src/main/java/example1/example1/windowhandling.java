package example1.example1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class windowhandling{
	 
	public static WebDriver driver;
 
   public static void main(String[] args)   throws InterruptedException{
	   
	   
	
	    System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		  driver=new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("http://www.americangolf.co.uk/");
        String handle= driver.getWindowHandle();
        
        System.out.println(handle);
        
       String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath(".//*[@id='header-top-wrapper']/div/div[3]/div[1]/div/ul/li[1]/a")).sendKeys(selectLinkOpeninNewTab);
    
		
		for (String handle1 : driver.getWindowHandles()) {
			 
        	System.out.println(handle1);
        	

        	driver.switchTo().window(handle1);

        	}
		
		Thread.sleep(11000);
		
        //driver.switchTo().window(0);
       // WebElement link = driver.findElement(By.xpath(".//*[@id='header-top-wrapper']/div/div[3]/div[1]/div/ul/li[1]/a"));
       // Actions newwin = new Actions(driver);
        
       // newwin.sendKeys(Keys.CONTROL +"t").click(link).build().perform();
        
        
 
		//Switch to the parent window
		
		//close the parent window
		//driver.close();
		//at this point there is no focused window, we have to explicitly switch back to some window.
		//driver.switchTo().window(lastWindowHandle);
        
           Thread.sleep(6000);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      /*  WebElement obj = driver.findElement(By.xpath(".//*[@id='header-navigation']/div[1]/ul/li[1]/a"));
        win = driver.getWindowHandles();
        Actions mouse = new Actions(driver);
       
       //mouse.moveToElement(obj).perform();
       mouse.moveToElement(obj).clickAndHold().build().perform();
       
       Thread.sleep(5000);
       
       Set<String> win = driver.getWindowHandles();
    	
    	System.out.println("No of Windows:"+win.size());
    	//Iterator<String> it = handles.iterator();
    	Iterator it=win.iterator();
    	
    	System.out.println(it.next());
 
    	win=driver.getWindowHandles();
    	System.out.println("No of windows:"+win.size());
    	it=win.iterator();
       
       */
       
       //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
       
       
       
      // driver.findElement(By.xpath(".//*[@id='header-top-wrapper']/div/div[3]/div[1]/div/ul/li[1]/a")).click();
      // win = driver.getWindowHandles();
      // System.out.println("No of Windows:"+win.size());
        //b.click().build().perform();
        
        
        //
        
       // Select sel = new Select(wb);
        
       // sel.selectByIndex(3);
        
       // mouse.release();
        
        //mouse.doubleClick(wb);
       
       driver.quit();
 
       /* Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
 
        driver.findElement(By.id("rpp")).click();*/
 
        }
 
}