package har;

import static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class codetest {
   
    @Test
    public void asserttrue() throws InterruptedException {
    	
    	   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
           driver.get("https://www.google.co.in");
        
        driver.manage().window().maximize();
        Thread.sleep(2000);
        
        driver.findElement(By.className("gsfi")).sendKeys("testing");
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(3000);
        
        WebElement resultsLabel = driver.findElement(By.id("resultStats"));
        assertTrue(resultsLabel.isDisplayed());
        driver.close();
    }
   
    @Test
    public void assertequals() throws InterruptedException, IOException {
    	   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
           driver.get("https://www.google.co.in");
           
           driver.manage().window().maximize();
           Thread.sleep(2000);
           
        driver.findElement(By.className("gsfi")).sendKeys("forest");
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(3000); 
        
        // take the screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        
        FileUtils.copyFile(scrFile, new File("D:\\tmp\\screenshot.png"));
        WebElement resultsLabel = driver.findElement(By.id("resultStats"));
        
        assertEquals(true, resultsLabel.isDisplayed());
        driver.close(); // This will not execute if the above assert fails otherwise it will execute.
    }
   
}
