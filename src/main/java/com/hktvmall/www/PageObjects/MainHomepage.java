package com.hktvmall.www.PageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.hktvmall.www.libs.Scroll;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class MainHomepage extends BasePage {
	
	private WebDriver dr;
	private find fd;
	private Wait wait;
	private Scroll scr;
	private int i;
	private boolean flag;
	private int size;
	private Actions actions;

	public MainHomepage(WebDriver driver){
		super(driver);
		this.dr= driver;
		fd = new find(this.dr);
		wait = new Wait(this.dr);
		scr= new Scroll(this.dr);
		actions = new Actions(driver);
	}
	
	public WebElement minicartLink(){
		return fd.what(objectStore.minicart);
	}
	
	public WebElement minicartCheckout(){
		return fd.what(objectStore.minicartCheckout);
	}
	
	public List<WebElement> HotpicksItems(){
		return fd.whats(objectStore.hotpicks);
	}
	/*
	public String getGlobalMessages(){
		wait.waitFortime(10000);
		String script = "document.getElementById('globalMessages').style.display='block'";
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript(script);
		GlobalMessages = fd.what(objectStore.globalMessages).getText();
		return GlobalMessages;
	}
	*/
	
	public String getHelloName(){
		wait.waitForElementPresent(objectStore.HelloName);
		return fd.what(objectStore.HelloName).getText();
	}
	
	
	public void goToCategory(){
		fd.what(objectStore.Main_Link).click();
		wait.waitForElementClickable(objectStore.subCategoryLink);
		fd.what(objectStore.subCategoryLink).click();
	}
	
	public void saveButtonClick(){
		wait.waitForElementPresent(objectStore.Hotpicks_title);
		scr.scrollBy(objectStore.Hotpicks_title);
		wait.waitForElementPresent(objectStore.FirstHotpicks);
		String script = "document.getElementsByClassName('quick-view-section')[0].style.display = 'block'";
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript(script);
		wait.waitForElementClickable(objectStore.FirstSave);
		fd.what(objectStore.FirstSave).click();
		wait.waitForPageLoad();
	}
	
	public void addtoCartClick(int Qty){
		wait.waitForElementPresent(objectStore.Hotpicks_title);
		scr.scrollBy(objectStore.Hotpicks_title);
		wait.waitForElementsPresent(objectStore.FirstHotpicks);
		flag = false;
		size = 0;
		for (i=0;i<HotpicksItems().size();i++){
			String script = "document.getElementsByClassName('product-grid-addtocart')["+String.valueOf(i)+"].style.display='block'";
			JavascriptExecutor js = (JavascriptExecutor) dr;
			js.executeScript(script);
			WebElement addToCart = fd.what(objectStore.hotpicks+"["+String.valueOf(i+1)+"]"+objectStore.QtyAddtoCart); 
			WebElement QtyCountUp = fd.what(objectStore.hotpicks+"["+String.valueOf(i+1)+"]"+objectStore.QtyCountUp);
			if(addToCart.isEnabled()){
				if(Qty>1)
				{
					for(int i=1;i<Qty;i++){
						QtyCountUp.click();
					}
					addToCart.click();
				}
				else if(Qty==1){
					addToCart.click();
				}
				flag = true;
				break;
			}
			else{
				++size;
				if((size==HotpicksItems().size())&&flag==false){
					actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
					wait.waitForPageLoad();
				}
			}
		}
		scr.scrollBy(objectStore.siteLogo);
	}
	
	public void goToWishlist(){
		fd.what(objectStore.wishlistInBottom).click();
		wait.waitForElementClickable(objectStore.wishlistLink);
		fd.what(objectStore.wishlistLink).click();
	}
	

}
