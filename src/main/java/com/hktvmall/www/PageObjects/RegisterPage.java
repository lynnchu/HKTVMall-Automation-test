package com.hktvmall.www.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hktvmall.www.libs.Scroll;
import com.hktvmall.www.libs.objectStore;
import com.hktvmall.www.libs.DataInputStore;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;

public class RegisterPage {
	private WebDriver dr;
	private find fd;
	public String firstName;
	public String lastName;
	private Wait wait;
	private Scroll scroll;
	
	
	public RegisterPage(WebDriver driver){
		this.dr= driver;
		fd = new find(dr);
		wait= new Wait(dr);
		scroll = new Scroll(dr);
	}

	
	public void Register(String registerName, String Password){
		  fd.what(objectStore.register_Name).sendKeys(registerName+"@mailinator.com");
		  this.firstName= registerName+"F";
		  this.lastName = registerName+"L";
		  fd.what(objectStore.register_firstName).sendKeys(this.firstName);
		  fd.what(objectStore.register_lastName).sendKeys(this.lastName);
		  this.SelectValue(2);
		  scroll.scrollTo(objectStore.register_Gendar);
		  fd.what(objectStore.register_Gendar).click();
		  fd.what(objectStore.register_PWD).sendKeys(Password);
		  fd.what(objectStore.register_CheckPwd).sendKeys(Password);
		  scroll.scrollTo(objectStore.register_Button);
		  wait.waitForElementClickable(objectStore.register_Button);
		  fd.what(objectStore.register_Button).click();
	}
	

	  
	  public void SelectValue(int index){
			Select sel = new Select(fd.what(objectStore.register_selectAge));
			sel.selectByIndex(index);
	  }

}
