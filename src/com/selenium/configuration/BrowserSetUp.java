package com.selenium.configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
/**
 * 
 * @author Lingaraj
 *
 */
public class BrowserSetUp {

	//public static WebDriver driver;
	//static RemoteWebDriver rdriver;

	@Parameters({ "browser" })
	public static WebDriver launchLocalBrowser(String browser) {
		WebDriver driver = null;
		if (browser == null) {
			throw new AssertionError("Something is wrong... WebDriver is not initialized");
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
		}else if(browser.toLowerCase().equals("emulator")) {
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Nexus 5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
		}
		driver.manage().timeouts().implicitlyWait(120L, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	@Parameters({ "browser" })
	public static WebDriver launchRemoteBrowser(String browserType) throws MalformedURLException{
		RemoteWebDriver rdriver;
		DesiredCapabilities dr=null;
		if(browserType.equals("firefox")){
			dr=DesiredCapabilities.firefox();
			dr.setBrowserName("firefox");
			dr.setPlatform(Platform.WINDOWS);
		}else if(browserType.equals("ie")){
			dr=DesiredCapabilities.internetExplorer();
			dr.setBrowserName("iexplore");
			dr.setPlatform(Platform.WINDOWS);
		}else if(browserType.equals("chrome")){
			dr=DesiredCapabilities.chrome();
		}
		rdriver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
		
		return rdriver;
	}
}
