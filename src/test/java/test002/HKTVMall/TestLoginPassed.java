package test002.HKTVMall;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hktvmall.www.PageObjects.LoginPage;
import com.hktvmall.www.PageObjects.MainHomepage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.DataInputStore;
import com.hktvmall.www.libs.ScreenShot;
import com.hktvmall.www.libs.objectStore;

public class TestLoginPassed {
	private Browser br;
	private WebDriver driver;
	private LoginPage loginPage;
	private MainHomepage mainhomepage;
	private String helloName;
	private ScreenShot scrshot;
	
	
@BeforeClass
public void intial(){
	br = new Browser(BrowserType.chrome);
	this.driver= br.webdriver;
}

@Test
public void testLoginPassed(){
	this.driver.get(objectStore.login_URL);
	loginPage = new LoginPage(this.driver);
	loginPage.login(DataInputStore.common_userName,DataInputStore.password);
	mainhomepage = new MainHomepage(this.driver);
	helloName = mainhomepage.getHelloName();
	scrshot = new ScreenShot();
	scrshot.takeScreenShot("mainpageAfterLogin", this.driver);
	Assert.assertTrue(helloName.contains("Hello"));	
}

@AfterClass
public void quit(){
	driver.quit();
}
}
