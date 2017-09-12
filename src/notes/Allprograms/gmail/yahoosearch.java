package gmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class yahoosearch {


public static void main(String[] args) throws InterruptedException { 
	
	WebDriver driver1;
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe"); 
	
	driver1 = new ChromeDriver();
	driver1.get("https://in.search.yahoo.com/") ;  
	
	System.out.println("Page title is " + driver1.getTitle() );
	

	
    driver1.findElement(By.xpath(".//*[@id='yschsp']")).sendKeys("This is relative xpath");
    //Thread.sleep(10000) ;
     //driver1.findElement(By.xpath("html/body/div[2]/div[1]/div/div/form/div/input")).sendKeys("This is Absolute xpath");
	      //driver1.findElement(By.id("lst-ib")).sendKeys("Selenium"); 
	  //driver1.findElement(By.linkText("Gmail") ).click();     
	
     Thread.sleep(10000) ;
	
	driver1.quit();
}
}


