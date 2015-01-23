package com.hktvmall.www.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hktvmall.www.libs.Scroll;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class WishlistPage extends BasePage {
	private WebDriver dr;
	private find fd;
	private Wait wait;
	private Scroll scr;
	
	
	public WishlistPage(WebDriver driver){
		super(driver);
		this.dr= driver;
		fd = new find(dr);
		wait = new Wait(dr);
		scr = new Scroll(dr);
		
	}
	
	public WebElement selectAll(){
		return fd.what("//div[@class='wishlist-act']//span[@class='text-select']");
	}
	
	public WebElement removeProducts(){
		return fd.what("//a[@id='remove-product']");
	}
	
	public void deleteAllProductsInWishlist(){
		if(selectAll().isEnabled()){
			scr.scrollBy("//div[@class='wishlist-act']//span[@class='text-select']");
			selectAll().click();
			wait.waitForElementClickable("//a[@id='remove-product']");
			removeProducts().click();
			scr.scrollBy(objectStore.siteLogo);
		}
	}
	
	public int getWishlistItems(){
		return fd.whats(objectStore.wishlistSelect).size();
	}
	
	

}
