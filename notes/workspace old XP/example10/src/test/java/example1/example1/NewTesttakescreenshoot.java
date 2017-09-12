package example1.example1;

import java.io.File;

import org.testng.annotations.*;
import org.testng.Assert.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTesttakescreenshoot {
	
	WebDriver driver;
  @Test
  public void a() {
	  
	  
	    System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	     
  }
  
  @BeforeClass
  public void setUp() throws Exception {
	  driver=new ChromeDriver();
  }
  @AfterClass
  public void tearDown() throws Exception {
      driver.quit();
}
  
  @Test
  public void uploadFile() throws Exception {
      String filename = "D:\\Durga Resume.txt";
      File file = new File(filename);
      
      String path = file.getAbsolutePath();
      
      driver.get("http://the-internet.herokuapp.com/upload");
      getscreenshot();
      
      driver.findElement(By.id("file-upload")).sendKeys(path);
      
      Thread.sleep(3000);
      
      driver.findElement(By.id("file-submit")).click();
      getscreenshot();
      
      String text = driver.findElement(By.id("uploaded-files")).getText();
      Thread.sleep(3000);
      assertThat(text, is(equals(filename)));
      
      System.out.printf("File is uploaded");
  }
  
  public void getscreenshot() throws Exception 
  {
          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          
       //The below method will save the screen shot in d drive with name "screenshot.png"
          
          
          
          FileUtils.copyFile(scrFile, new File("D:\\screenshot"+System.currentTimeMillis()+".png"));
          
          //FileUtils.copyFile(src, new File("C:/selenium/"+System.currentTimeMillis()+".png"));
  }
  

private void assertThat(String text, Object object) {
	// TODO Auto-generated method stub
	
}

private Object is(boolean equals) {
	// TODO Auto-generated method stub
	return null;
}
}
