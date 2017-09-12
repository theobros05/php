package example1.example1;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames2 {
	WebDriver driver;
	public static void main(String[] args)   throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();

	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://seleniumhq.github.io/selenium/docs/api/java/");
	
	int size = driver.findElements(By.tagName("frame")).size();
	
	System.out.println("Total number of frames are  "+ size);
	
	int isize = driver.findElements(By.tagName("iframe")).size();
	
	System.out.println("Total number of iframes are  "+ isize);
	
	
 
	
	
	
	//((WebElement) driver).getAttribute("name");
	
	//System.out.println("Navigated to frame with id "  );
	
	System.out.println("Frame name :" + ((WebElement) driver).getAttribute("name"));
	
	List<WebElement> ele = driver.findElements(By.tagName("frame"));
    System.out.println("Number of frames in a page :" + ele.size());
    for(WebElement el : ele){
      //Returns the Id of a frame.
        System.out.println("Frame Id :" + el.getAttribute("id"));
      //Returns the Name of a frame.
        System.out.println("Frame name :" + el.getAttribute("name"));
    }
	
   WebElement r0=driver.findElementByName("packageListFrame");
   WebElement r1=driver.findElementByName("packageFrame");
   WebElement r2=driver.findElementByName("classFrame");
   
    driver.switchTo().frame(r1);
    
    System.out.println("Frame name :" + ((WebElement) driver).getAttribute("name"));
   
   driver.findElement(By.cssSelector(".indexContainer>ul>li>a")).click();
   
   Thread.sleep(3000);
   
   driver.navigate().back();
   driver.switchTo().frame(r0);
   //driver.switchTo().defaultContent();
   //driver.findElement(By.cssSelector(".colFirst>a")).click();
   
   
   Thread.sleep(5000);

   
   
driver.quit();


}
	
}
