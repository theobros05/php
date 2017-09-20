package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {
	public static Logger logger = Logger.getLogger(TestBase.class.getName());

	//public static Logger logger = Logger.getLogger("mylogger");
	public static Calendar calendar = Calendar.getInstance();
	public static WebDriver driver;
	public static Properties OR;
	public static File f1;
	public static FileInputStream file;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest er;
	public ITestResult result;
	public static String browser;

	public static void getBrowser() throws Exception {

		TestBase.loadPropertiesFile();

		browser = OR.getProperty("Browser");

		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("firefox")) {
				// https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				// https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("html")) {

				driver = new HtmlUnitDriver(true);
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			System.out.println(System.getProperty("os.name"));
			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
			}
		}
	}

	static {

		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/main/java/Report/ExtentReport3.0-"
				+ formater.format(calendar.getTime()) + ".html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("BrowerType", "Chrome");

		extent.setSystemInfo("Author", "Theo");

		htmlReporter.config().setDocumentTitle("Report");

		htmlReporter.config().setReportName("Tech Fetch candidate pages");
		
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

		htmlReporter.config().setTheme(Theme.STANDARD); // DARK

		htmlReporter.config().setEncoding("utf-8");

	}

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			er.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test passed", ExtentColor.GREEN));

		} else if (result.getStatus() == ITestResult.SKIP) {

			//er.log(Status.SKIP, result.getName() + " Test is skipped and skip reason is:-" + result.getThrowable());

			er.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + "Test is skipped and skip reason is:-" + result.getThrowable(),ExtentColor.ORANGE));

		} else if (result.getStatus() == ITestResult.FAILURE) {

			er.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " -Test failed" + result.getThrowable(),ExtentColor.RED));
			
		} else if (result.getStatus() == ITestResult.STARTED) {

			er.log(Status.INFO, MarkupHelper.createLabel(result.getName() + " - Test started", ExtentColor.BROWN));
		}
	}

	public void screenShot(ITestResult result) {
		if (ITestResult.SUCCESS != result.getStatus()) {
			try {
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\src\\main\\java\\screenshot\\"
						+ result.getName() + formater.format(calendar.getTime()) + ".png"));

				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
		screenShot(result);
	}

	@BeforeMethod
	public void beforeMethod(Method result) {

		er = extent.createTest(result.getName());

		er.log(Status.INFO, MarkupHelper.createLabel(result.getName() + " -Test started", ExtentColor.GREEN));

	}

	@AfterClass(alwaysRun = true)
	public void endTest() {	
		extent.flush();
	}

	public static void loadPropertiesFile() throws IOException {

		String log4jConfPath = System.getProperty("user.dir") + "/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		System.out.println(System.getProperty("user.dir"));
		OR = new Properties();

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Login.properties");

		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Login.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Browsertype.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Browsertype.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Logout.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Logout.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Delete.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Delete.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Feature.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Feature.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Fetch.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Fetch.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Forward.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Forward.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Listing.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Listing.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Update.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		// logger.info("loading Update.properties");

		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/ReplaceDoc.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		
		f1 = new File(System.getProperty("user.dir") + "/src/main/resources/property/Forward.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		logger.info("Loading all properties files");
	}

	public static WebElement getLocator(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public List<WebElement> getLocators(String locator) throws Exception {
		System.out.println(locator);
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		System.out.println("locatorType:-" + locatorType);
		System.out.println("locatorValue:-" + locatorValue);

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public static WebElement getWebElement(String locator) throws Exception {
		return getLocator(OR.getProperty(locator));
	}

	public List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(OR.getProperty(locator));
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Testbase executing");
	}

}
