package com.selenium.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.utils.ReadExcelSheetData;



/**
 * 
 * @author Lingaraj
 *
 */
public class BaseClass {
	public WebDriver driver;
	protected ReadExcelSheetData testdata;

	static ExtentTest test;
	static ExtentReports report;
	@BeforeSuite
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");

	}

	@BeforeMethod
	@Parameters({"environment","browser","datafile","sheet" })
	public void beforeTest(String environment,String browser,String datafile,String sheetname) throws Exception {
		//	test = report.startTest((this.getClass().getSimpleName() + "::"+method.getName()));
		if(environment.toLowerCase().equals("local"))
			driver = BrowserSetUp.launchLocalBrowser(browser);
		else if(environment.toLowerCase().equals("remote"))
			driver = BrowserSetUp.launchRemoteBrowser(browser);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		testdata = new ReadExcelSheetData(datafile,sheetname);
		driver.get(testdata.getValue("url"));

	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

	@AfterSuite
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}

}
