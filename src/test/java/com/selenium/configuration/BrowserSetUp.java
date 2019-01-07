package com.selenium.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
/**
 * 
 * @author Lingaraj
 *
 */
public class BrowserSetUp {

	public static WebDriver driver;

	@SuppressWarnings("unused")
	@Parameters({ "browser" })
	public static WebDriver launchBrowser(String browser) {
		if (browser == null) {
			throw new AssertionError("Something is wrong... WebDriver instance is tried to be re-initialized");
		}
		if (browser.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.toLowerCase().equals("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		} else if (browser.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(120L, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
