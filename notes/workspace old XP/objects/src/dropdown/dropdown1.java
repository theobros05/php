package dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown1 {
 public static void main(String[] args) { 
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	    String baseUrl = "https://www.bing.com/account/general?ru=https%3a%2f%2fwww.bing.com%2f&FORM=O2HV65&id=language_section#language-section";
	    WebDriver driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		
		

		//Select drpCountry = new Select(driver.findElement(By.name("country")));
		//drpCountry.selectByVisibleText("ANTARCTICA");

		//Selecting Items in a Multiple SELECT elements
		///driver.get("http://jsbin.com/osebed/2");
		///Select fruits = new Select(driver.findElement(By.id("fruits")));
		//fruits.selectByVisibleText("Banana");
		//fruits.selectByIndex(1);
		
		
 }
}