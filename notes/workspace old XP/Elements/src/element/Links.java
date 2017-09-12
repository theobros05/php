package element;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Links {

private static String homeWindow = null;
private static String[] links = null;
private static int linksCount = 0;

public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
	driver.get("http://www.tiliconveli.com/");
	
// Fllowing instruction extract all links from the webpage using selenium webdriver
List<WebElement> all_links_webpage = driver.findElements(By.tagName("a"));

// Print total no of links on the webpage
System.out.println("Print total no of links on the webpage----------------------------------------------------");
linksCount = all_links_webpage.size();

System.out.println(linksCount);
links= new String[linksCount];// Following instruction stores each link and Prints on console
System.out.println("Print Links-----------------------------------------------------------------------------------");

for(int i=0;i<linksCount;i++)
{
links[i] = all_links_webpage.get(i).getAttribute("href");
System.out.println(all_links_webpage.get(i).getAttribute("href"));
}
// Following instruction Return an opaque handle to this window that uniquely identifies it within this driver instance.
// This can be used to switch to this window at a later date
homeWindow = driver.getWindowHandle().toString();
// Visiting Each Link in on the Page

System.out.println("Visiting Each Links------------------------------------------------------------------------");
Iterator<WebElement> ite = all_links_webpage.iterator();

while(ite.hasNext()) {
	
    WebElement anchor = ite.next();

for(int i=0;i<linksCount;i++)
{
	
	
driver.navigate().to(links[i]);
Thread.sleep(3000);
driver.switchTo().window(homeWindow);
}
driver.quit();
}
} }