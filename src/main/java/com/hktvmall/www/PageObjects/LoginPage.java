package com.hktvmall.www.PageObjects;

import org.openqa.selenium.WebDriver;

import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class LoginPage extends BasePage {
	private WebDriver dr;
	private find fd;
	private Wait wait;
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.dr= driver;
		fd = new find(dr);
		wait = new Wait(dr);
	}
	
	public void login(String userName,String Password){
		fd.what(objectStore.login_UserName).sendKeys(userName);
		fd.what(objectStore.login_Password).sendKeys(Password);
		fd.what(objectStore.login_Button).click();
	}
	
	/*
	public String getGlobalMessages(){
		wait.waitForElementPresent(objectStore.globalMessages);
		GlobalMessages = fd.what(objectStore.globalMessages).getText();
		return GlobalMessages;
	}
	*/
}
