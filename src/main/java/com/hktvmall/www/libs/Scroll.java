package com.hktvmall.www.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {
	public WebDriver driver;
	private Wait wait;
	
	public Scroll(WebDriver dr){
		this.driver = dr;
		wait = new Wait(dr);
	}
	
	public void scrollTo(String locator){
		WebElement elementToClick = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
	}
	
	public void scrollBy(String locator){
		Point point= driver.findElement(By.xpath(locator)).getLocation();
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,6000)","");
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+point.getX()+","+point.getY()+")","");
		wait.waitFortime(3000);
	}
	
	
	public void scrollByElement(WebElement element){
		Point point = element.getLocation();
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+point.getX()+","+point.getY()+")","");
		wait.waitFortime(3000);
	}
	
	
}
