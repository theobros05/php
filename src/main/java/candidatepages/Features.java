package candidatepages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import testbase.TestBase;

public class Features extends TestBase {

	public static void feature() throws Exception {

		logger = Logger.getLogger(Features.class.getName());
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.switchTo().defaultContent();

		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		getWebElement("features_Click").click();
		logger.info("Opening Features Tab");
		er.log(Status.INFO, "Opening Features Tab");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getWebElement("demandIndex").click();
		logger.info("Opening DemandIndex Tab");
		er.log(Status.INFO, "Opening DemandIndex Tab");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.switchTo().frame("contentframe");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		getWebElement("profile").click();
		logger.info("clicking Profile List");
		er.log(Status.INFO, "clicking Profile List");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Select select = new Select(getWebElement("profile"));
		logger.info("Selecting Profile List");
		er.log(Status.INFO, "Selecting Profile List");
		Select select1 = new Select(getWebElement("spealized"));
		logger.info("Selecting Spealized List");
		er.log(Status.INFO, "Selecting Spealized List");
		Select select2 = new Select(getWebElement("date"));
		logger.info("Selecting Date List");
		er.log(Status.INFO, "Selecting Date List");
		Select select3 = new Select(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ddlstate']"))));
		logger.info("Selecting state List");
		er.log(Status.INFO, "Selecting state List");

		for (int i = 0; i < 1; i++) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			select.selectByIndex(i);
			logger.info("Selecting Profile List");
			er.log(Status.INFO, "Selecting Profile List");
			for (int i1 = 0; i1 < 1; i1++) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				select1.selectByIndex(i);
				logger.info("Selecting Spealized List");
				er.log(Status.INFO, "Selecting Spealized List");
				for (int i2 = 0; i2 < 1; i2++) {
					select2.selectByIndex(i);
					logger.info("Selecting Date List");
					er.log(Status.INFO, "Selecting Date List");
					for (int i3 = 0; i3 < 1; i3++) {

						select3.selectByVisibleText("CA");
						logger.info("Selecting state List");
						er.log(Status.INFO, "Selecting state List");
						getWebElement("seeresult").click();
						logger.info("clicking Seeresult");
						er.log(Status.INFO, "clicking Seeresult");
						Thread.sleep(5000);
						select3.selectByVisibleText("FL");
						logger.info("Selecting state List");
						er.log(Status.INFO, "Selecting state List");
						getWebElement("seeresult").click();
						logger.info("clicking Seeresult");
						
						Thread.sleep(5000);
						select3.selectByVisibleText("SC");
						logger.info("Selecting state List");
						er.log(Status.INFO, "Selecting state List");
						getWebElement("seeresult").click();
						logger.info("clicking Seeresult");
						er.log(Status.INFO, "clicking Seeresult");
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					}
				}
			}
		}
		Thread.sleep(5000);

	}

	public static void main(String[] args) throws Exception {
		TestBase.getBrowser();
		Login.run();
		Features.feature();
		Logout.out();
	}

}