package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	
	By addGiftMsgCheckbox=By.xpath("//*[text()='Add a gift message']");
	By giftMsgToTextbox=By.xpath("//legend[text()='To']/following-sibling::div/input");
	By giftMsgFromTextbox=By.xpath("//legend[text()='From']/following-sibling::div/input");
	By giftMsgFromTextarea=By.xpath("//legend[div[contains(text(),'Gift')]]/following-sibling::div/textarea");
	By contactInfoEmail=By.xpath("//div[div[text()='Contact info']]//legend[text()='Email Address']/following-sibling::div/input");
	By contactInfoPhone=By.xpath("//div[div[text()='Contact info']]//legend[text()='Phone Number']/following-sibling::div/input");
	

	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
}
