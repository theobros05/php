package dropdown;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownauto {
 public static void main(String[] args) throws InterruptedException{ 
	 
	 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
     WebDriver driver = new ChromeDriver(); 
     String baseUrl = "https://www.bing.com/account/general?ru=https%3a%2f%2fwww.bing.com%2f&FORM=O2HV65&id=language_section#language-section";
	 driver.get(baseUrl);
		
	 WebElement d = driver.findElement(By.xpath(".//*[@id='rpp']"));
	 d.click();
		
	 Thread.sleep(10000);
	 Select auto = new Select(driver.findElement(By.xpath(".//*[@id='rpp']")));
	 
	 auto.selectByIndex(1);
	
	
		
	 WebElement option = auto.getFirstSelectedOption();	
	 System.out.println(option.getText()); 
	/* auto.selectByVisibleText("30");
		//auto.getFirstSelectedOption();
		
		WebElement option = auto.getFirstSelectedOption();
		
		
		System.out.println(option.getText()); 
		
		//auto.selectByVisibleText("30");
		//List<WebElement> e = auto.getOptions();
		
		//System.out.println(((WebElement) e).getText());
		
		//int itemCount = e.size();

		//for(int l = 0; l < itemCount; l++)
		//{
		//    System.out.println(e.get(l).getText());*/
		//}
        driver.quit();
 }}