package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PdpPage {
	
	
	
	private WebDriver driver;
	By atcButton=By.xpath("//button[@atc=\"product_Add to cart\"]");
	By savetoListLink=By.linkText("Save to List");
	By shippingRadioButton=By.id("SHIPPING");
	By viewCartButton=By.xpath("//button[contains(text(),'View Cart')]");
	By qtyPlus=By.xpath("//div[contains(@class,'plusIcon')]");


	public PdpPage(WebDriver driver) {
		this.driver=driver;

	}
	
	public void clickATCButton() {
		driver.findElement(atcButton).click();
		
	}
	
	public void clickSaveToListLink() {
		
	}

}
