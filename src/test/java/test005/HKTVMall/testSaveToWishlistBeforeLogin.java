package test005.HKTVMall;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hktvmall.www.PageObjects.LoginPage;
import com.hktvmall.www.PageObjects.MainHomepage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.objectStore;

public class testSaveToWishlistBeforeLogin {
	private Browser br;
	private WebDriver driver;
	private LoginPage loginPage;
	private MainHomepage mainHomepage;
	

@BeforeClass
public void intial(){
	br = new Browser(BrowserType.chrome);
	this.driver= br.webdriver;
	loginPage = new LoginPage(driver);
	mainHomepage = new MainHomepage(driver);
}

@Test
public void testSavetoWishlistBeforeLogin(){
	driver.get(objectStore.MainPageURL);
	mainHomepage.saveButtonClick();
	String globalMessages = loginPage.getGlobalMessages();
	Assert.assertTrue(globalMessages.contains("Please log in to add this product to wishlist"));	
}


@AfterClass
public void quit(){
	driver.quit();
}
}
