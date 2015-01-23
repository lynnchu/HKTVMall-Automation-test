package com.hktvmall.www.libs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public WebDriver driver;
	
	public Wait(WebDriver dr){
		this.driver= dr;
	}
	
	public void waitForElementPresent(String locator){
		WebDriverWait waiter = new WebDriverWait(driver, 20);
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	
	}
	
	public void waitForElementsPresent(String locator){
		WebDriverWait waiter = new WebDriverWait(driver, 20);
		waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(locator))));
	
	}
	
	
	public void waitForElementClickable(String locator){
		WebDriverWait waiter = new WebDriverWait(driver, 20);
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));	
	}
	
	public void waitFortime(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForPageLoad() {
	    WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> pageLoadCondition = new
		        ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver driver) {
		                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		            }
		        };

		    wait.until(pageLoadCondition);
	}
}
