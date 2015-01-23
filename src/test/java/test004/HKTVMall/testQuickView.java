//--------------Author:Lynn-----------------
package test004.HKTVMall;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.ScreenShot;
import com.hktvmall.www.libs.Scroll;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class testQuickView {

	private Browser br;
	private WebDriver driver;
	private find fd;
	private Wait wait;
	private Scroll scr;
	private ScreenShot scrshot;
	

@BeforeClass
public void intial(){
	br = new Browser(BrowserType.chrome);
	this.driver= br.webdriver;
	fd= new find(driver);
	wait = new Wait(driver);
	scr= new Scroll(driver);
	scrshot = new ScreenShot();
}

@Test
public void testQuickview(){
	driver.get(objectStore.MainPageURL);
	wait.waitForElementPresent(objectStore.Hotpicks_title);
	scr.scrollBy(objectStore.Hotpicks_title);
	wait.waitForElementPresent(objectStore.FirstHotpicks);
	String script = "document.getElementsByClassName('quick-view-section')[0].style.display = 'block'";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript(script);
	wait.waitForElementClickable(objectStore.FirstQuickView);
	fd.what(objectStore.FirstQuickView).click();
	wait.waitForPageLoad();
	wait.waitForElementPresent(objectStore.viewDetailsInQVpage);
	String quickViewLinktext = fd.what(objectStore.viewDetailsInQVpage).getText();
	Assert.assertTrue(quickViewLinktext.contains("View full details"));
	scrshot.takeScreenShot("QuickView", driver);
}


@AfterClass
public void quit(){
	driver.quit();
}

}
