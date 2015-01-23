package test001.HKTVMall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hktvmall.www.PageObjects.RegisterPage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.DataInputStore;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class TestRegisterFailed {
	private Browser br;
	private WebDriver driver;
	private RegisterPage registerPage;
	public WebElement emailError;
	private find fd;
	
	
	@BeforeClass
	public void intial(){
		br = new Browser(BrowserType.chrome);
		this.driver= br.webdriver;
		fd = new find(driver);

	}
	
	@Test
	public void testRegisterFailed(){
		driver.get(objectStore.register_URL);
		registerPage = new RegisterPage(driver);
		registerPage.Register("testhktv",DataInputStore.password);
		emailError = fd.what(objectStore.register_emailError);
		Assert.assertTrue(this.emailError.getText().contains("An account already exists for this email address"));
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
