package com.hktvmall.www.PageObjects;

import org.openqa.selenium.WebDriver;

import com.hktvmall.www.libs.Switch;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.PageObjects.*;

public class Mailinator {
	private WebDriver dr;
	private find fd;
	private Wait wait;
	private Switch sw;
	
	public Mailinator(WebDriver driver){
		this.dr= driver;
		fd = new find(dr);
		wait = new Wait(dr);
		sw = new Switch(dr);
		dr.get("http://www.mailinator.com");	
	}
	
	public MainHomepage ActiveAccount(String registername){
		fd.what("//input[@id='inboxfield']").sendKeys(registername);
		fd.what("//btn[preceding-sibling::input[@id='inboxfield']]").click();
		wait.waitForElementClickable("//ul[@id='mailcontainer']/li[last()]");
		fd.what("//ul[@id='mailcontainer']/li[last()]").click();
		wait.waitForElementPresent("//iframe[@name='rendermail']");
		sw.ToSpecficiFrame("//iframe[@name='rendermail']");
		wait.waitForElementClickable("//a[contains(@href,'activate')]");
		fd.what("//a[contains(@href,'activate')]").click();
		return new MainHomepage(dr);
	}
}
