package hotel;
 
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class CalendarHandling {
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	public static void main(String[] args) throws InterruptedException 
	{
		
		Date date = new Date();
        System.out.println(sdf.format(date));

        Calendar cal = Calendar.getInstance();
        System.out.println(sdf.format(cal.getTime()));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
        
   
        String seldate="14/09/2017";
        Date date1 = new Date(seldate);
        
        SimpleDateFormat dt= new  SimpleDateFormat("MMM");
		
        String d=dt.format(date1);
        System.out.println(d);
        
      //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");
 
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        
        
     /*   ChromeDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.goibibo.com/");
        driver.findElement(By.xpath("//div[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/input")).click();
        
        Thread.sleep(3000);
        
        
        
        driver.findElement(By.id("fare_20170816")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='searchWidgetCommon']/div/div[3]/div[1]/div[2]/div/input[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("fare_20170914")).click();
        Thread.sleep(3000);
        
        */
        
        
		}
		

 
}