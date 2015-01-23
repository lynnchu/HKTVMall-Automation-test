//---------------------Author:Lynn---------------------
package test005.HKTVMall;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hktvmall.www.PageObjects.LoginPage;
import com.hktvmall.www.PageObjects.MainHomepage;
import com.hktvmall.www.PageObjects.WishlistPage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.DataInputStore;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.objectStore;

public class testSaveToWishlistAfterLogin {
	private Browser br;
	private WebDriver driver;
	private Wait wait;
	private LoginPage loginPage;
	private WishlistPage wishlistPage;
	private MainHomepage mainHomepage;
	

@BeforeClass
public void intial(){
	br = new Browser(BrowserType.chrome);
	this.driver= br.webdriver;
	wait = new Wait(driver);
	loginPage = new LoginPage(driver);
	wishlistPage = new WishlistPage(driver);
	mainHomepage = new MainHomepage(driver);
}

@Test
public void testSavetoWishlistAfterLogin(){
	driver.get(objectStore.login_URL);
	this.driver.get(objectStore.login_URL);
	loginPage = new LoginPage(this.driver);
	loginPage.login(DataInputStore.common_userName,DataInputStore.password);
	wait.waitForPageLoad();
	mainHomepage.goToWishlist();
	wait.waitForPageLoad();
	wishlistPage.deleteAllProductsInWishlist();
	wishlistPage.siteLogo().click();
	wait.waitForPageLoad();
	mainHomepage.saveButtonClick();
	mainHomepage.goToWishlist();
	wait.waitForPageLoad();
	Assert.assertEquals(wishlistPage.getWishlistItems(), 1);
}



@AfterClass
public void quit(){
	driver.quit();
}
}
