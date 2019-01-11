package com.selenium.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PLPPage {
	private WebDriver driver;

	By showDropDown=By.id("pageSize");
	By productsCount=By.xpath("//div[@class='plp-product-content-wrapper']");
	By deliverycheckbox = By.id("delivery_checkbox");
	By shippingcheckbox= By.id("shipping_checkbox");
	By pickupcheckbox= By.id("pickup_checkbox");
	By pickupLabel=By.xpath("//input[@id='pickup_checkbox']/following-sibling::label");
	By shipingLabel=By.xpath("//input[@id='shipping_checkbox']/following-sibling::label");
	By deliveryLabel=By.xpath("//input[@id='delivery_checkbox']/following-sibling::label");
	
	By produtname=By.xpath("//section//li[4]//h2[@class='plp-product-title']/a");
    By Productimg=By.xpath("//li[1]//div[@class=\"plp-list-product-img\"]");
    By productprice=By.xpath("//li[1]//span[@class=\"price\"]");
    By add_to_cart=By.xpath("//li[1]//div[@class=\"add_to_cart_form clear_fix\"]");
    By savetolist=By.xpath("//div[@class=\"plp-list-buy-ctrls\"]//div[2]");
    By sortby=By.xpath("//select[@id=\"sortOptions\"]");
    By pagesize=By.xpath("//select[@name=\"dropdown\"]");
    By pickupinstore=By.xpath("//a[@class=\" an_isp\"]");
    By shipto=By.xpath("//a[@class=\" an_shipTo\"]");
    By reviewlink=By.xpath("//li[1]//div[@class=\"plp-product-ratreview\"][1]");



	public PLPPage(WebDriver driver) {
		this.driver=driver;

	}
	
	public void selectShowDropDownAndVerify() {
		List<String> list=new ArrayList<String>();
		list.add("24");list.add("96");list.add("180");
		for(String val:list) {
		Select oSelect = new Select(driver.findElement(showDropDown));
		oSelect.selectByValue(val);
		Assert.assertEquals(driver.findElements(productsCount).size()+"", val);
		}
		
	}
	


}
