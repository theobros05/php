package element;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class checkbox {
	private static String[] links = null;
	private static int checkcount = 0;
	public static void main(String[] args) throws InterruptedException { 
		 
	
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
	driver.get("https://www.bing.com/account/general?ru=https%3a%2f%2fwww.bing.com%2f&FORM=O2HV65&id=language_section#language-section");
	
	List<WebElement> checksize = driver.findElements(By.cssSelector("input[type=checkbox]")); 
	checkcount = checksize.size();
	
	System.out.println("Total no of checkbox Available: "+checkcount);
	links= new String[checkcount];
	
	System.out.println("List of checkbox Available: ");  
	
	for(int i=0;i<checkcount;i++)
	{
	links[i] = checksize.get(i).getAttribute("id");
	
	
    System.out.println(checksize.get(i).getAttribute("id"));
	} 
	
	
	Thread.sleep(3000);
	driver.quit();
	

}}
