package com.hktvmall.www.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class BasePage {
	protected  final WebDriver dr;
	public Wait wait;
	public find fd;
	public String GlobalMessages;
	
	public BasePage(WebDriver driver){
		this.dr = driver;
		fd = new find(dr);
		wait = new Wait(dr);
	}
	
    public void GoTo(String url){
    	this.dr.get(url);
    }
    
    public String currentUrl(){
    	return this.dr.getCurrentUrl();
    }
    
    public WebElement siteLogo(){
    	return fd.what(objectStore.siteLogo);
    }
    
	public String getGlobalMessages(){
		wait.waitFortime(10000);
		String script = "document.getElementById('globalMessages').style.display='block'";
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript(script);
		GlobalMessages = fd.what(objectStore.globalMessages).getText();
		return GlobalMessages;
	}
}
