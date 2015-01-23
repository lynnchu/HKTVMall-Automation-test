package com.hktvmall.www.PageObjects;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hktvmall.www.libs.Scroll;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class CartPage extends BasePage {
	private WebDriver dr;
	private find fd;
	private Wait wait;
	private Scroll scr;
	
	
	public CartPage(WebDriver driver){
		super(driver);
		this.dr= driver;
		fd = new find(dr);
		wait = new Wait(dr);
		scr = new Scroll(dr);
	}
	
	public List<WebElement> removeProducts(){
		return fd.whats(objectStore.removeProducts);
	}
	
	public void removeAllProducts(){
		if(!removeProducts().isEmpty()){
		for(WebElement removeProduct:removeProducts()) {
			scr.scrollByElement(removeProduct);
			removeProduct.click();
			}
		}
		scr.scrollBy(objectStore.siteLogo);
	}
}
