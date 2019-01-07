package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.utils.ReadExcelSheetData;





public class HeaderPage
{

	private WebDriver driver;
	WebDriverWait wait;
	By ageGateYes=By.id("btnYes");
	By searchBox=By.xpath("//input[contains(@id,'search')]");
	By signInRegisterLink=By.xpath("//*[contains(text(),'Sign In')]");
	By userNameTextBox=By.id("j_username");
	By passwordTextBox=By.id("j_password");
	By loginSignInButton=By.xpath("(//button[contains(@class,'anLoginSubmit')])[1]");
	By searchButton_v2=By.id("at_searchProductsBtn");
	By searchButton_v1=By.className("search-right-cont-mini-search-logo analyticsSearch");
	By viewallwine=By.xpath("//div[text()='View All Wine']");

	public HeaderPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(this.driver, 20);

	}

	/*
	 * Function to click on YES button in age gate modal
	 */
	public void ClickYesInAgeGate() throws InterruptedException {
		driver.findElement(ageGateYes).click();
		Thread.sleep(4000);
		driver.findElement(searchBox).click();
		Cookie ck = new Cookie("2018Q2_OCHEADER", "enabled");
		driver.manage().addCookie(ck);
		driver.navigate().refresh();
		Thread.sleep(4000);

	}

	/*
	 * Function to click on signin/register link from home page
	 */
	public void clickLoginlink() throws InterruptedException {
		driver.findElement(signInRegisterLink).click();;
		Thread.sleep(4000);
	}

	/*
	 * 
	 */
	public void enterUsername(String username) {
		driver.switchTo().frame("iframe-signin-overlay");
		driver.findElement(userNameTextBox).sendKeys(username);

	}

	/*
	 * 
	 */
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);

	}

	/*
	 * 
	 */
	public void clickSignInButton() {
		driver.findElement(loginSignInButton).click();

	}

	/*
	 * 
	 */
	public void loginToTWM(ReadExcelSheetData testdata) throws Exception {
		enterUsername(testdata.getValue("username"));
		enterPassword(testdata.getValue("password"));
		clickSignInButton();
	}

	/*
	 * 
	 */
	public void searchProduct(String searchKey) {
		wait.until(ExpectedConditions.elementToBeClickable(searchBox)).sendKeys(searchKey+Keys.ENTER);

	}

	/*
	 * 
	 */
	public void clearSearchBox() {
		driver.findElement(searchBox).clear();
	}
	
	
	public void clickViewAllWineButton() {
		driver.findElement(viewallwine).click();
	}

	/*
	 * 
	 */
	public void navigateToViewAllWinesPage() {
		WebElement element = driver.findElement(By.linkText("Product Category"));
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(driver.findElement(By.linkText("iPads"))).click().build().perform();
	}
}
