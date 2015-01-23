package com.hktvmall.www.libs;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Switch {
	WebDriver driver;
	String currentwindow;
	
	public Switch(WebDriver dr){
		this.driver = dr;
		currentwindow= driver.getWindowHandle();
	}
	
	public void ToSpecficWindow(String partialTitleName){
		  Set<String> handles =  driver.getWindowHandles();
		  
	/*	  Iterator<String> it = handles.iterator();
		  while(it.hasNext()){
			  if(currentwindow == it.next())continue;
			  String titlename;
			  titlename = driver.switchTo().window(it.next()).getTitle();
			  if(titlename.contains(partialTitleName))
				  break;
			  }
		  */
		  for (String handle : handles) {
			String titlename;
			titlename = driver.switchTo().window(handle).getTitle();
			  if(titlename.contains(partialTitleName))
				  break;
		}
	}
	
	public void BacktoCurrentWindow(){
		driver.switchTo().window(currentwindow);
	}
	
	public void ToSpecficiFrame(String locator){
		driver.switchTo().frame(driver.findElement(By.xpath(locator)));
	}
}


