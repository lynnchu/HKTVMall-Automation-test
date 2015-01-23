package test006.HKTVMall;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hktvmall.www.PageObjects.CartPage;
import com.hktvmall.www.PageObjects.LoginPage;
import com.hktvmall.www.PageObjects.MainHomepage;
import com.hktvmall.www.PageObjects.WishlistPage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.Scroll;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.objectStore;

public class testAddToCart {
	private Browser br;
	private WebDriver driver;
	private Wait wait;
	private LoginPage loginPage;
	private CartPage cartPage;
	private MainHomepage mainHomepage;
	private Scroll scr;
	
	@BeforeClass
	public void intial(){
		br = new Browser(BrowserType.chrome);
		this.driver= br.webdriver;
		loginPage = new LoginPage(driver);
		mainHomepage = new MainHomepage(driver);
		cartPage = new CartPage(driver);
		scr = new Scroll(driver);
	}
	
	@Test
	public void testAddtoCart(){
		driver.get(objectStore.cartURL);
		wait.waitForPageLoad();
		cartPage.removeAllProducts();
		cartPage.siteLogo().click();
		wait.waitForPageLoad();
		mainHomepage.addtoCartClick(2);
		mainHomepage.minicartLink().click();
		mainHomepage.minicartCheckout().click();
		wait.waitForPageLoad();
		
		
		
		
		
		
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
