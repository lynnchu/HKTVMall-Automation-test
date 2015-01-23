package com.hktvmall.www.libs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class find {
 public WebDriver driver;
 
 
 //ParaseProperties locator = new ParaseProperties(System.getProperty("user.dir")+"\\Tools\\objectStore.properties");
 
   public find(WebDriver dr){
	   this.driver = dr;
   }
	
   public WebElement what(String locatorname){	   
	   //return this.driver.findElement(By.xpath(locator.getKey(locatorname)));
	   return this.driver.findElement(By.xpath(locatorname));
   }
   
   public List<WebElement> whats(String locatorname){	   
	   //return this.driver.findElements(By.xpath(locator.getKey(locatorname)));
	   return this.driver.findElements(By.xpath(locatorname));
   }
   
   
}
