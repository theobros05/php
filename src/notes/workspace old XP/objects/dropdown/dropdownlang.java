package dropdown;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownlang {
 public static void main(String[] args)  throws InterruptedException{ 
	 
	 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
     WebDriver driver = new ChromeDriver(); 
     String baseUrl = "https://www.bing.com/account/general?ru=https%3a%2f%2fwww.bing.com%2f&FORM=O2HV65&id=language_section#language-section";
	 driver.get(baseUrl);
		
	 WebElement d = driver.findElement(By.xpath(".//*[@id='setlang']"));
	 d.click();//to first time click and open the drop down
	 
	 Thread.sleep(3000);
		

		Select auto = new Select(driver.findElement(By.xpath(".//*[@id='setlang']")));
		
	
		
		List<WebElement> e = auto.getOptions();
		
		int itemCount = e.size();

		for(int l = 0; l < itemCount; l++)
		{
		    System.out.println(e.get(l).getText());
		}
        
 }}