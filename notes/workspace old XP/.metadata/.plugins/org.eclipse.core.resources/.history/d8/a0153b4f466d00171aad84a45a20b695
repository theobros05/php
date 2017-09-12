package log4j_demo;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	 
	public class PracticeSwitchWindow {
	        public static WebDriver driver;
	        final static Logger logger = Logger.getLogger("devpinoyLogger");
	 
	        public static void main(String[] args) throws InterruptedException {
	            BasicConfigurator.configure();
	            // Create a new instance of the Firefox driver
	 
	            System.setProperty("webdriver.gecko.driver","C:\\Users\\subu\\Documents\\geckodriver.exe");
	            driver = new FirefoxDriver();
	            
	            logger.info("chrome opening in window : ");
	 
	            // Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	 
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            logger.warn("chrome waiting : ");
	            // Launch the URL
	 
	            driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
	 
	            // Store and Print the name of the First window on the console
	 
	            String handle= driver.getWindowHandle();
	 
	            System.out.println(handle);
	            logger.warn("chrome handling window : ");
	            // Click on the Button "New Message Window"
	 
	            driver.findElement(By.xpath(".//*[@id='content']/p[4]/button")).click();
	 
	            // Store and Print the name of all the windows open                  
	           Thread.sleep(1000);
	            Set handles = driver.getWindowHandles();
	 
	            System.out.println(handles);
	 
	            // Pass a window handle to the other window
	 
	            for (String handle1 : driver.getWindowHandles()) {
	 
	                System.out.println(handle1);
	 
	                driver.switchTo().window(handle1);
	 
	                }
	          
	            logger.debug("chrome switching window : ");
	            // Closing Pop Up window
	 
	            driver.close();
	 
	            // Close Original window
	 
	            driver.quit();
	 
	    }
	 
	}

