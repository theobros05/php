package obj1;

import org.testng.annotations.Test;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.testng.Assert;

import java.util.concurrent.*;


public class Asserttry {
	

	WebDriver driver = new ChromeDriver();
	
	public void open(){
  
  String curTitle = driver.getTitle();
  String newTitle = driver.getTitle();
  Assert.assertTrue(curTitle.equals(newTitle), "You've been redirected");
	}  
	  
  }

