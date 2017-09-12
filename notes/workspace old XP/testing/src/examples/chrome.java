package examples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class chrome {


public static void main(String[] args) throws InterruptedException { 
	
	WebDriver driver1;
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe"); 
	
	driver1 = new ChromeDriver(); driver1.get("http://google.com") ;  
	
	System.out.println("Page title is " + driver1.getTitle() ) ;
	
           driver1.findElement(By.name("q")).sendKeys("Pleasanton");
	      driver1.findElement(By.id("lst-ib")).sendKeys("Selenium"); 
	  driver1.findElement(By.linkText("Gmail") ).click();     
	
	Thread.sleep(10000) ;
	
	driver1.quit(); ; 
}
}


