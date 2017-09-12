package examples;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class interexp {


public static void main(String[] args) throws InterruptedException { 
	
	WebDriver driver1; 
	
	System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");

	WebDriver driver = new InternetExplorerDriver();

	
	
	//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
	
	//System.setProperty("webdriver.chrome.driver","D:\\firefoxdriver.exe"); 

	driver1 = new InternetExplorerDriver(); 
	driver1.get("http://www.tiliconveli.com") ; 
	
	
	System.out.println("Page title is " + driver1.getTitle() ) ;
	
    //        driver1.findElement(By.name("q")).sendKeys("Pleasanton");
	//      driver1.findElement(By.id("lst-ib")).sendKeys("Selenium"); 
	//  driver1.findElement(By.linkText("Gmail") ).click();     
	
	Thread.sleep(10000);
	
	driver1.quit();
}
}
