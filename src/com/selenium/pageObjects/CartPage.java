package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver=driver;

	}
	
	By zipcodeTextbox=By.xpath("//input[@id='zipCode'] | //*[text()='Submit']/preceding-sibling::input");

}
