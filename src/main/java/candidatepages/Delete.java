package candidatepages;

import testbase.TestBase;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import com.aventstack.extentreports.Status;
import candidatepages.Login;
import candidatepages.Logout;

public class Delete extends TestBase {

	public static void remove() throws Exception { // code done

		logger = Logger.getLogger(Delete.class.getName());

		/*
		 * driver.switchTo().defaultContent(); // switching to content frame
		 * driver.switchTo().frame("contentframe"); // clicking the delete icon
		 * getWebElement("delete").click();
		 * 
		 * logger.info("delete button clicked on content frame");
		 * 
		 * driver.switchTo().defaultContent();
		 * 
		 * 
		 * driver.switchTo().frame("deleteprofilecontentframe");
		 * 
		 * logger.info("switched to delete profile content frame");
		 * //Thread.sleep(1000);
		 * driver.manage().timeouts().pageLoadTimeout(7,TimeUnit.SECONDS);
		 * 
		 * logger.info("To make profile confidential");
		 * 
		 * getWebElement("confidential").click(); //Thread.sleep(1000);
		 * driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 * getWebElement("btnDelete").click();
		 * 
		 * logger.info("submit button clicked"); //Thread.sleep(1000);
		 * driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 * 
		 * 
		 * 
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("contentframe");
		 * 
		 * getWebElement("delete").click();
		 * 
		 * logger.info("delete button clicked on content frame");
		 * 
		 * //Thread.sleep(1000);
		 * driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("deleteprofilecontentframe");
		 * 
		 * logger.info("To click Make My Resume NOT Available");
		 * 
		 * getWebElement("NotAvailable").click(); //Thread.sleep(2000);
		 * driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 * getWebElement("btnDelete").click(); logger.info("submit button clicked");
		 * driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 * //Thread.sleep(3000);
		 * 
		 */
		driver.switchTo().defaultContent();

		driver.switchTo().frame("contentframe");

		getWebElement("delete").click();

		logger.info("Delete button clicked on content frame");
		er.log(Status.INFO, "Delete button clicked on content frame");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("deleteprofilecontentframe");

		logger.info("Delete My Profile Permanently");
		er.log(Status.INFO, "Delete My Profile Permanently");
		getWebElement("rdDelete").click();

		getWebElement("btnDelete").click();
		logger.info("submit button clicked");
		er.log(Status.INFO, "submit button clicked");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("deleteprofilecontentframe");

		getWebElement("rdbtnParttimeno").click();

		logger.info("clicking the radio buttton");
		er.log(Status.INFO, "clicking the radio buttton");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getWebElement("deleteprofile").click();
		logger.info("clicking delete button");
		er.log(Status.INFO, "clicking delete button");
		er.log(Status.INFO, "Redirecting to logout");
		Thread.sleep(5000);

	}

	public static void main(String[] args) throws Exception {
		TestBase.getBrowser();
		Login.run();
		Delete.remove();
		Logout.out();

	}
}
