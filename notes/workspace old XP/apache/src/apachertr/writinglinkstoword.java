package apachertr;

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class writinglinkstoword
{
private static String[] links = null;
private static int linksCount = 0;

    public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException
    {
    	
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
       
    		 
    	
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
    	driver.get("http://www.techfetch.com/");
    	
    	List<WebElement> linksize = driver.findElements(By.tagName("a")); 
    	linksCount = linksize.size();
    	
    	System.out.println("Total no of links Available: "+linksCount);
    	links= new String[linksCount];
    	
    	System.out.println("List of links Available: "); 
    	
    	run.setText("Number of available links in  "+ driver.getTitle() +" is  " + linksCount);
    	
    	run.addBreak();
    	run.setFontSize(12);
    	
    	run.setFontFamily("Times New Roman");
    	for(int i=0;i<linksCount;i++)
    	{
    	links[i] = linksize.get(i).getAttribute("href");
    	
    	//run.setText(linksize.get(i).getAttribute("href"));
    	
        run.setText((linksize.get(i).getAttribute("href")) + "\n");
        
        run.addBreak();
    	
        System.out.println(linksize.get(i).getAttribute("href"));
        
    	} 
    	
    	
    	Thread.sleep(3000);
    	driver.quit();
    	

    

       
        
        FileOutputStream out = new FileOutputStream("D:\\Success.doc");
        document.write(out);
        out.close();
    }
}