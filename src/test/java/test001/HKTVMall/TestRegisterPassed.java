package test001.HKTVMall;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.hktvmall.www.PageObjects.Mailinator;
import com.hktvmall.www.PageObjects.MainHomepage;
import com.hktvmall.www.PageObjects.RegisterPage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.DataInputStore;
import com.hktvmall.www.libs.Switch;
import com.hktvmall.www.libs.objectStore;


public class TestRegisterPassed {
	private Browser br;
	private WebDriver driver;
	private RegisterPage registerPage;
	private Mailinator Mail;
	private Switch sw;
	private MainHomepage mainhomepage;
	private String message;
	private String registerName;

	
@BeforeClass
public void intial(){
	br = new Browser(BrowserType.chrome);
	this.driver= br.webdriver;	
}	

  @Test
  public void testRegisterPassed() {
	  this.driver.get(objectStore.register_URL);
	  registerPage = new RegisterPage(this.driver);
	  registerName= "test"+this.CalcDate();
	  registerPage.Register(registerName,DataInputStore.password);
	  Mail = new Mailinator(this.driver);
	  sw= new Switch(this.driver);
	  mainhomepage = Mail.ActiveAccount(registerName);
	  sw.ToSpecficWindow(objectStore.MainPage_Title);
	  mainhomepage.getGlobalMessages();
	  this.message = mainhomepage.GlobalMessages;
	  Assert.assertTrue(this.message.contains("successfully register"));
  }
  

  @AfterClass
  public void quit(){
	  driver.quit();
  }
  
  public String CalcDate(){
	  Date now = new Date();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	  return dateFormat.format(now);
  }
  
}
