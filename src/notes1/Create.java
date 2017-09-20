package check;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import candidatepages.Login;
import testbase.TestBase;
 
public class Create
{
    ExtentReports extent;
    ExtentTest test;
     

    public void config()
    {
     
        extent= new ExtentReports(System.getProperty("user.dir")+"/src/main/java/check/logfile"+System.currentTimeMillis()+".html",true);
    }
     

    public void stepLogsGeneration()
    {
        test = extent.startTest("stepLogsGeneration");
        
        test.log(LogStatus.INFO, "startTest() method will return the Extent Test object ");
        test.log(LogStatus.INFO, "I am in actual test method");
        test.log(LogStatus.INFO, "We Can Write The Actual Test Logic In This Test");
    }
         
  
    public void tearDown()
    {
        extent.endTest(test);
        
        test.log(LogStatus.INFO, "endTest() method will stop capturing information about the test log");
        extent.flush();
        test.log(LogStatus.INFO, "flush() method of ExtentReports wil push/write everything to the document");
        test.log(LogStatus.INFO, "close() method will clear/close all resource of the ExtentReports object");
        extent.close();
    }
    
    public static void main(String[] args) throws Exception {
    	Create t= new Create();
    	t.config();
    	t.stepLogsGeneration();
    	t.tearDown();
    	
	}
}