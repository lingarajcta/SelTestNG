package com.selenium.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	private static WebDriver driver;
	public CommonFunctions(WebDriver driver) {
		this.driver=driver;
	}

	public static void MouseOver(WebElement we){
		Actions actObj=new Actions(driver);
		actObj.moveToElement(we).build().perform();
	}

	public static String fn_GetTimeStamp(){
		DateFormat DF=DateFormat.getDateTimeInstance();
		Date dte=new Date();
		String DateValue=DF.format(dte);
		DateValue=DateValue.replaceAll(":", "_");
		DateValue=DateValue.replaceAll(",", "");
		return DateValue;
	}


	//select the dropdown using "select by visible text", so pass VisibleText as 'Yellow' to funtion
	public static void fn_Select(WebElement WE, String VisibleText){
		Select selObj=new Select(WE);
		selObj.selectByVisibleText(VisibleText);
	}

	//select the dropdown using "select by index", so pass IndexValue as '2'
	public static void fn_Select(WebElement WE, int IndexValue){
		Select selObj=new Select(WE);
		selObj.selectByIndex(IndexValue);
	}

	//select the dropdown using "select by value", so pass Value as 'thirdcolor'
	public static void fn_SelectByValue(WebElement WE, String Value){
		Select selObj=new Select(WE);
		selObj.selectByValue(Value);
	}

	/**
	 * @param driver
	 *            WebDriver reference
	 * @param waitTime
	 *            integer type waiting time
	 */
	public void commonWaitToLoad(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}


	public boolean waitForJQueryProcessing(WebDriver driver,
			int timeOutInSeconds) {
		boolean jQcondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
			// implicitlyWait()
			(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                JavascriptExecutor js = (JavascriptExecutor) d;
	                String readyState = js.executeScript("return document.readyState").toString();
	              //  System.out.println("Ready State: " + readyState);
	                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
	            }
	        });
			jQcondition = (Boolean) ((JavascriptExecutor) driver)
					.executeScript("return jQuery.active == 0");
			System.out.println(jQcondition);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // reset
			// implicitlyWait
			return jQcondition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jQcondition;
	}

}
