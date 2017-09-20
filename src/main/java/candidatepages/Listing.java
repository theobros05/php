package candidatepages;

import java.util.concurrent.TimeUnit;
import testbase.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;



public class Listing extends TestBase {
	static WebDriverWait wait;

	public static void list() throws Exception {
		logger = Logger.getLogger(Listing.class.getName());
		
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		// jobalert menu
		getWebElement("jobAlertmenu").click();
		// create jobalert
		getWebElement("createJobalert").click();
		logger.info("Clicking Create jobalert ");
		er.log(Status.INFO, "Clicking Create jobalert");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select Select = new Select(getWebElement("profileSelection"));
		logger.info("Selecting profile ");
		er.log(Status.INFO, "Selecting profile");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		Select.selectByIndex(5);
		getWebElement(("excludeCompany")).sendKeys(("excludeCompanyname"));
		logger.info("Entering exclude company name");
		er.log(Status.INFO, "Entering exclude company name");
		
		wait = new WebDriverWait(driver, 15);
		getWebElement(("alertName1")).sendKeys(("alertName"));
		getWebElement(("saveButton")).click();
		logger.info("Clicking save alert");
		er.log(Status.INFO, "Clicking save alert");
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		getWebElement(("menu")).click();
		
		wait = new WebDriverWait(driver, 30);
		// alert list
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		/*
		getWebElement(("alertList")).click();
		logger.info("Clicking alertlist");
		
		wait = new WebDriverWait(driver, 30);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select select1 = new Select(getWebElement(("consoliDatedalert")));
		select1.selectByIndex(0);
		logger.info("consoliDatedalert");
		Select select2 = new Select(getWebElement("instantAlert"));
		select2.selectByIndex(0);
		logger.info("instantAlert");
		
		wait = new WebDriverWait(driver, 20);
		// delete alert
		getWebElement("deleteicon").click();
		logger.info("deleteicon");

		driver.switchTo().alert().accept();
		logger.info("End of job alert");
		
		driver.switchTo().defaultContent();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);*/
		er.log(Status.INFO, "Redirecting to logout");
		 Thread.sleep(5000);
	}

	public static void main(String[] args) throws Exception {
		TestBase.getBrowser();
		Login.run();
		Listing.list();
		Logout.out();

	}
}
