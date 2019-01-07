package com.selenium.suits;

import org.testng.annotations.Test;

import com.selenium.configuration.BaseClass;
import com.selenium.pageObjects.HeaderPage;
import com.selenium.pageObjects.PLPPage;


public class BasicTestNGClass extends BaseClass{

	@Test()
	public void verifyShowDropDowninPLP() throws Exception {
		//ExtentTestManager.getTest().setDescription("To validate Show Drop options in PLP page");
		HeaderPage homepage=new HeaderPage(driver);
		homepage.ClickYesInAgeGate();
		homepage.clickLoginlink();
		homepage.loginToTWM(testdata);
		Thread.sleep(4000);
		homepage.searchProduct("wines");
		homepage.clickViewAllWineButton();
		PLPPage plp=new PLPPage(driver);
		plp.selectShowDropDownAndVerify();

	}
	
	@Test(enabled=false)
	public void loginTest1() throws Exception {
		HeaderPage homepage=new HeaderPage(driver);
		homepage.ClickYesInAgeGate();
		homepage.clickLoginlink();
		homepage.loginToTWM(testdata);
		Thread.sleep(4000);
	}

	

}
