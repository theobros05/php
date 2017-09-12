package dropdown;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class getlinks {
	private static String[] links = null;
	private static int linksCount = 0;
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException { 
		 
		
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
	driver.get("http://www.tiliconveli.com/");
	
	List<WebElement> linksize = driver.findElements(By.tagName("a")); 
	linksCount = linksize.size();
	
	
         
         
	System.out.println("Total no of radio Available: "+linksCount);
	links= new String[linksCount];
	
	System.out.println("List of links Available: ");  
	
	for(int i=0;i<linksCount;i++)
	{
	links[i] = linksize.get(i).getAttribute("href");
	
	
    System.out.println(linksize.get(i).getAttribute("href"));
	} 
	
	
	Thread.sleep(3000);
	driver.quit();
	

}
	
	
	
	public void clickLinkByHref(String href, int position) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
 
        int j = 0;
        while(i.hasNext()) {
            WebElement anchor = i.next();
 
            if(anchor.getAttribute("href").contains(href)) {
                j++;
            }
 
            if(anchor.getAttribute("href").contains(href)
                    && j == position) {
                anchor.click();
                break;
            }
        }
    }	
}
